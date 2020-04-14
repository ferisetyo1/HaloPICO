package feri.com.halopico.modul.home

import android.content.ActivityNotFoundException
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import feri.com.halopico.R
import feri.com.halopico.data.Data
import feri.com.halopico.model.SoalModel
import feri.com.halopico.modul.MainActivity
import feri.com.halopico.modul.autentikasi.LoginActivity
import feri.com.halopico.modul.histori.HistoryActivity
import feri.com.halopico.modul.skrinning.SkrinningActivity
import feri.com.halopico.util.Const
import feri.com.halopico.util.Helper
import kotlinx.android.synthetic.main.bottom_sheet_recomm.view.*
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    val mAuth = FirebaseAuth.getInstance()
    val mDB = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val builderdialog = AlertDialog.Builder(context!!)
        builderdialog.setCancelable(false)
        val inflater =
            context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        val dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        val curUser = mAuth.currentUser
        val reffUser = mDB.collection(Const.user).document(curUser?.uid!!)
        reffUser.get().addOnSuccessListener {
            dialog.dismiss()
            if (it.exists()) {
                nama_user.text = "${nama_user.text} ${it.getString("nama")?.split(" ")?.get(0)}"
                if (!it.getString("kondisiPsikologis").isNullOrEmpty()) {
                    psikologisConditional.text = "(${it.getString("kondisiPsikologis")})"
                }
                lastSkrinning.text = Helper.longtoDate(it.getTimestamp("lastSkrinning")?.toDate()!!)
            } else {
                mAuth.signOut()
                startActivity(Intent(context, LoginActivity::class.java))
                (context as MainActivity).finish()
            }
        }.addOnFailureListener {
            dialog.dismiss()
        }

        update_btn.setOnClickListener {
            val builderdialog = AlertDialog.Builder(context!!)
            builderdialog.setCancelable(false)
            val inflater =
                context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            builderdialog.setView(inflater.inflate(R.layout.progress, null))
            val dialog = builderdialog.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
            mDB.collection(Const.soal).whereEqualTo("tipe", 1).get()
                .addOnSuccessListener {
                    dialog.dismiss()
                    if (!it.isEmpty) {
                        val list = ArrayList<SoalModel>()
                        list.addAll(it.toObjects(SoalModel::class.java))
                        startActivity(
                            Intent(context, SkrinningActivity::class.java)
                                .putExtra("listSoal", list)
                        )
                    } else {
                        Toast.makeText(
                            context,
                            "Konteks masih belum tersedia",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                .addOnFailureListener {
                    dialog.dismiss()
                    Toast.makeText(
                        context,
                        it.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
        btn_history.setOnClickListener {
            startActivity(Intent(context, HistoryActivity::class.java))
        }
        btn_rekom.setOnClickListener {
            val bts = BottomSheetDialog(context!!)
            val parentView = layoutInflater.inflate(R.layout.bottom_sheet_recomm, null)
            parentView.video.setOnClickListener {
                var id = Data.ytKondisigetid(
                    psikologisConditional.text.toString().replace("(", "").replace(")", "")
                )
                if (!id.isNullOrEmpty()) {
                    val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
                    val webIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://www.youtube.com/watch?v=$id")
                    )
                    try {
                        context!!.startActivity(appIntent)
                    } catch (ex: ActivityNotFoundException) {
                        context!!.startActivity(webIntent)
                    }
                } else {
                    Toast.makeText(context, "Konteks tidak tersedia", Toast.LENGTH_LONG).show()
                }
            }
            parentView.foto.setOnClickListener {
                var data = Data.kondisifotoUrl(
                    psikologisConditional.text.toString().replace("(", "").replace(")", "")
                )
                val imageUri = (Uri.Builder())
                        .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                    .authority(resources.getResourcePackageName(R.drawable.kondisi1))
                    .appendPath(resources.getResourceTypeName(R.drawable.kondisi1))
                    .appendPath(resources.getResourceEntryName(R.drawable.kondisi1)+".png")
                    .build()
                if (!data.isNullOrEmpty()) {
//                    val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath("kondisi1")
//                    val intent=Intent(Intent.ACTION_VIEW,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//                    intent.setDataAndType(Uri.parse("android.resource://feri.com.halopico/drawable/$data"),"image/*")
//                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    context!!.startActivity(intent)
//                    startActivity(
//                        Intent(
//                            Intent.ACTION_VIEW,
//                            imageUri
//                        ).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//                    )
                } else {
                    Toast.makeText(context, "Konteks tidak tersedia", Toast.LENGTH_LONG).show()
                }
            }
            bts.setContentView(parentView)
            bts.show()
        }
    }

}