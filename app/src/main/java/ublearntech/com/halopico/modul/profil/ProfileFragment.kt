package ublearntech.com.halopico.modul.profil

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Source
import kotlinx.android.synthetic.main.fragment_profile.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.model.UserModel
import ublearntech.com.halopico.modul.MainActivity
import ublearntech.com.halopico.modul.autentikasi.LoginActivity
import ublearntech.com.halopico.util.Const
import ublearntech.com.halopico.util.DBHelper

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    private val mDB = DBHelper.getDb()
    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
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
                val user = it.toObject(UserModel::class.java)
//                Glide.with(requireContext())
//                    .asDrawable()
//                    .load(user?.imgURL.toString())
//                    .circleCrop()
//                    .transition(withCrossFade())
//                    .error(ContextCompat.getDrawable(requireContext(),
//                        R.drawable.circle_error
//                    ))
//                    .into(imageProfil)
                txt_nama_user.text = user?.nama
            }
        }.addOnFailureListener {
            dialog.dismiss()
        }


        txt_profilCh.setOnClickListener {
            startActivity(Intent(context, UbahProfilActivity::class.java))
        }

        txt_passwordCh.setOnClickListener {
            startActivity(Intent(context,UbahPasswordActivity::class.java))
        }

        txt_keluar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(context, LoginActivity::class.java))
            (context as MainActivity).finish()
        }
    }
}
