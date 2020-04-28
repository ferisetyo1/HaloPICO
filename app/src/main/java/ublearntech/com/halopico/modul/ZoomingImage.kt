package ublearntech.com.halopico.modul

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ublearntech.com.halopico.R
import kotlinx.android.synthetic.main.activity_zooming_image.*

class ZoomingImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zooming_image)
        val imgid = intent.getIntExtra("imgid", 0)
        val kondisi=intent.getStringExtra("title")
        tv_title.text="Rekomendasi $kondisi"
        pv.setImageResource(imgid)
    }

    fun back(view: View) {
        onBackPressed()
    }
}
