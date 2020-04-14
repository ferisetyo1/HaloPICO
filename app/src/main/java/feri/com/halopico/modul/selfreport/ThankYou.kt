package feri.com.halopico.modul.selfreport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import feri.com.halopico.R
import feri.com.halopico.modul.MainActivity

class ThankYou : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)
    }

    fun processMain(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
