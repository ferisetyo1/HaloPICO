package feri.com.halopico.modul.autentikasi

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import feri.com.halopico.*
import feri.com.halopico.model.SoalModel
import feri.com.halopico.model.UserModel
import feri.com.halopico.modul.MainActivity
import feri.com.halopico.modul.selfreport.SelfReportActivity
import feri.com.halopico.modul.datadiri.DataDiriActivity
import feri.com.halopico.util.Const
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    val mDB = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Glide.with(this).asDrawable()
            .load(R.drawable.logo_filled)
            .transition(withCrossFade())
            .circleCrop()
            .error(R.drawable.ic_image)
            .into(logo)
    }

    fun processLogin(view: View) {
        if (!cek_input()) {
            return
        }
        val username = et_username.text.toString().trim()
        val email = "${username}@halopico.com"
        val password = et_password.text.toString().trim()

        val builderdialog = AlertDialog.Builder(this)
        builderdialog.setCancelable(false)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        val dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val curUser = mAuth.currentUser
                mDB.collection(Const.user).document(curUser?.uid!!).get()
                    .addOnSuccessListener { documentSnapshot ->
                        val user = documentSnapshot.toObject(UserModel::class.java)
                        when (user?.statusData) {
                            0 -> startActivity(Intent(this, DataDiriActivity::class.java))
                            1 -> {
                                mDB.collection(Const.soal).whereEqualTo("tipe", 0).get()
                                    .addOnSuccessListener {
                                        if (!it.isEmpty) {
                                            val list = ArrayList<SoalModel>()
                                            list.addAll(it.toObjects(SoalModel::class.java))
                                            startActivity(
                                                Intent(this, SelfReportActivity::class.java)
                                                    .putExtra("listSoal", list)
                                            )
                                        }
                                    }
                                    .addOnFailureListener {
                                        Toast.makeText(
                                            this,
                                            it.localizedMessage,
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                            }
                            2 -> startActivity(Intent(this, MainActivity::class.java))
                        }
                        dialog.dismiss()
                        finish()
                    }.addOnFailureListener {
                        dialog.dismiss()
                        Toast.makeText(
                            this,
                            it.localizedMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    }
            } else {
                dialog.dismiss()
                Toast.makeText(
                    this,
                    it.exception?.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun cek_input(): Boolean {
        disablerHelper()
        if (et_username.text.isNullOrEmpty()) {
            et_username.requestFocus()
            et_lyt_username.error = "Harap isi field yang kosong"
            return false
        }
        if (et_password.text.isNullOrEmpty()) {
            et_password.requestFocus()
            et_lyt_password.error = "Harap isi field yang kosong"
            return false
        }

        return true
    }

    fun disablerHelper() {
        et_lyt_username.error = null
        et_lyt_password.error = null
    }

    fun transferToRegister(view: View) {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}
