package feri.com.halopico.modul.profil

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import feri.com.halopico.R
import kotlinx.android.synthetic.main.activity_ubah_password.*

class UbahPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_password)
    }

    fun processSimpan(view: View) {
        if (!et_password.text!!.toString().equals(et_kon_password.text.toString())) {
            et_kon_password.requestFocus()
            et_lyt_kon_password.error = "Password tidak sama"
            return
        }

        val fauth = FirebaseAuth.getInstance()
        val currUser = fauth.currentUser
        val credential =
            EmailAuthProvider.getCredential(currUser!!.email!!, et_password_lama.text.toString())

        val builderdialog = AlertDialog.Builder(this)
        builderdialog.setCancelable(false)
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        val dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        currUser?.reauthenticate(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                currUser.updatePassword(et_password.text.toString()).addOnCompleteListener {
                    dialog.dismiss()
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Berhasil mengubah password", Toast.LENGTH_LONG).show()
                        finish()
                    } else {
                        Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_LONG)
                            .show()
                    }
                }
            } else {
                dialog.dismiss()
                Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun back(view: View) {
        onBackPressed()
    }
}
