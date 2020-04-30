package ublearntech.com.halopico.modul.home

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Source
import kotlinx.android.synthetic.main.fragment_home.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.data.Data
import ublearntech.com.halopico.model.SoalModel
import ublearntech.com.halopico.modul.MainActivity
import ublearntech.com.halopico.modul.autentikasi.LoginActivity
import ublearntech.com.halopico.modul.dialog.dialog_rekomendasi
import ublearntech.com.halopico.modul.histori.HistoryActivity
import ublearntech.com.halopico.modul.konsultasi.KonsultasiActivity
import ublearntech.com.halopico.modul.lihatselfreport.LihatSelfReport
import ublearntech.com.halopico.modul.skrinning.SkrinningActivity
import ublearntech.com.halopico.util.Const
import ublearntech.com.halopico.util.DBHelper
import ublearntech.com.halopico.util.Helper


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    val mAuth = FirebaseAuth.getInstance()
    val mDB = DBHelper.getDb()
    private val STORAGE_CODE: Int = 1001

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            //system OS >= Marshmallow(6.0), check permission is enabled or not
            if (checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED
            ) {
                //permission was not granted, request it
                val permissions = arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                requestPermissions(permissions, STORAGE_CODE)
            }
        }
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val builderdialog = AlertDialog.Builder(requireContext())
        builderdialog.setCancelable(false)
        val inflater =
            context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        val dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        val curUser = mAuth.currentUser
        val reffUser = mDB.collection(Const.user).document(curUser?.uid!!)
        reffUser.get(Source.CACHE).addOnSuccessListener {
            dialog.dismiss()
            if (it.exists()) {
                nama_user.text = "${nama_user.text} ${it.getString("nama")?.split(" ")?.get(0)}"
                if (!it.getString("kondisiPsikologis").isNullOrEmpty()) {
                    val kondisi = it.getString("kondisiPsikologis")
                    psikologisConditional.text = "($kondisi)"
                    kondisi_img.setImageDrawable(
                        requireContext().getDrawable(
                            Data.getIlustrasi(
                                kondisi!!
                            )
                        )
                    )
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
            val builderdialog = AlertDialog.Builder(requireContext())
            builderdialog.setCancelable(false)
            val inflater =
                context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            builderdialog.setView(inflater.inflate(R.layout.progress, null))
            val dialog = builderdialog.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
            mDB.collection(Const.soal).whereEqualTo("tipe", 1).get(Source.CACHE)
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
            val bts = dialog_rekomendasi(
                psikologisConditional.text.toString()
                    .substring(1, psikologisConditional.text.length - 1)
            )
            Log.d(
                "ppp",
                psikologisConditional.text.toString()
                    .substring(1, psikologisConditional.text.length - 1)
            )
            bts.show(parentFragmentManager, "DialogRekomendasi")
        }
        btn_selfreport.setOnClickListener {
            startActivity(Intent(requireContext(), LihatSelfReport::class.java))
        }

        btn_pakar.setOnClickListener {
            startActivity(Intent(requireContext(), KonsultasiActivity::class.java))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            STORAGE_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permission from popup was granted, call savePdf() method
                    //Toast.makeText(context!!, "Permission grant...!", Toast.LENGTH_SHORT).show()
                } else {
                    //permission from popup was denied, show error message
                    //Toast.makeText(context!!, "Permission denied...!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}