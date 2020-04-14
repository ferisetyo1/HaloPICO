package feri.com.halopico.modul.autentikasi

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import feri.com.halopico.R
import feri.com.halopico.model.UserModel
import feri.com.halopico.modul.datadiri.DataDiriActivity
import feri.com.halopico.util.Const
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    val mDB = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun processRegister(view: View) {
        if (!cek_input()) {
            return
        }
        val username = et_username.text.toString().trim()
        val nama = et_nama.text.toString().trim()
        val nohp = et_nohp.text.toString().trim()
        val email = "${username}@halopico.com"
        val password = et_password.text.toString().trim()

        val builderdialog = AlertDialog.Builder(this)
        builderdialog.setCancelable(false)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        val dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                var curUser = mAuth.currentUser
                var userModel= UserModel().apply {
                    this.nama=nama
                    this.userName=username
                    this.nohp=nohp
                    this.statusData=0
                }
                mDB.collection(Const.user).document(curUser?.uid!!).set(userModel)
                    .addOnCompleteListener {
                        dialog.dismiss()
                        if (it.isSuccessful) {
                            startActivity(Intent(this, DataDiriActivity::class.java))
                        } else {
                            Toast.makeText(
                                this,
                                it.exception?.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            } else {
                dialog.dismiss()
                Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun cek_input(): Boolean {
        disablerHelper()

        if (et_nama.text.isNullOrEmpty()) {
            et_nama.requestFocus()
            et_lyt_nama.error = "Harap isi field yang kosong"
            return false
        }
        if (et_nohp.text.isNullOrEmpty()) {
            et_nohp.requestFocus()
            et_lyt_nohp.error = "Harap isi field yang kosong"
            return false
        }
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
        if (et_password.text!!.length < 6) {
            et_password.requestFocus()
            et_lyt_password.error = "Password tidak boleh kurang dari 6 karakter"
            return false
        }
        if (et_kon_password.text.isNullOrEmpty()) {
            et_kon_password.requestFocus()
            et_lyt_kon_password.error = "Harap isi field yang kosong"
            return false
        }
        if (!et_password.text!!.toString().equals(et_kon_password.text.toString())) {
            et_kon_password.requestFocus()
            et_lyt_kon_password.error = "Password tidak sama"
            return false
        }

        Log.d("test", et_password.text!!.toString())
        Log.d("test", et_kon_password.text!!.toString())

        return true
    }

    fun disablerHelper() {
        et_lyt_nama.error = null
        et_lyt_nohp.error = null
        et_lyt_username.error = null
        et_lyt_password.error = null
        et_lyt_kon_password.error = null
    }

    fun transferToLogin(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
