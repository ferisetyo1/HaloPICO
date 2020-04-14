package feri.com.halopico.modul.selfreport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import feri.com.halopico.R
import feri.com.halopico.model.SoalModel
import kotlinx.android.synthetic.main.activity_self_report.*

class SelfReportActivity : AppCompatActivity() {

    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self_report)
        val listSoalModel = intent.getParcelableArrayListExtra<SoalModel>("listSoal")

        updateSoal(listSoalModel!!)
    }

    private fun updateSoal(
        listSoalModel: ArrayList<SoalModel>
    ) {
        if (listSoalModel.size <= counter) {
                startActivity(Intent(this, ThankYou::class.java))
                finish()
        } else {
            soal.text = listSoalModel.get(counter).pertanyaan
            listSoalModel.get(counter).jawaban.forEach {
                val button = MaterialButton(this).apply {
                    cornerRadius = 25
                    text = it.jawaban
                    setBackgroundColor(
                        ContextCompat.getColor(
                            this@SelfReportActivity,
                            R.color.SecondKemenkes
                        )
                    )
                }
                button.setOnClickListener {
                    lyt_jawaban.removeAllViews()
                    updateSoal(listSoalModel)
                }
                lyt_jawaban.addView(button)
            }

        }
        counter++
    }
}
