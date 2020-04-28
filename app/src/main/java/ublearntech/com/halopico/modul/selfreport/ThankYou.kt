package ublearntech.com.halopico.modul.selfreport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ublearntech.com.halopico.R
import ublearntech.com.halopico.modul.MainActivity

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
