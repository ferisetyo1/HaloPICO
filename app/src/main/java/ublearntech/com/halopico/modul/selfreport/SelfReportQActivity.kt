package ublearntech.com.halopico.modul.selfreport

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_self_report_q.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.model.LogSkrinningModel
import ublearntech.com.halopico.model.SoalModel
import ublearntech.com.halopico.util.Const
import ublearntech.com.halopico.util.DBHelper

class SelfReportQActivity : AppCompatActivity() {

    var counter = 0
    var listJawaban = ArrayList<LogSkrinningModel.JawabanUser>()
    val mDB = DBHelper.getDb()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self_report_q)
        val listSoalModel = intent.getParcelableArrayListExtra<SoalModel>("listSoal")

        updateSoal(listSoalModel!!)
    }

    private fun updateSoal(
        listSoalModel: ArrayList<SoalModel>
    ) {
        if (listSoalModel.size <= counter) {
            val curUser = FirebaseAuth.getInstance().currentUser
            val reffUser = mDB.collection(Const.user).document(curUser?.uid!!)
            val builderdialog = AlertDialog.Builder(this)
            builderdialog.setCancelable(false)
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            builderdialog.setView(inflater.inflate(R.layout.progress, null))
            val dialog = builderdialog.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
            val docData = hashMapOf(
                "statusData" to 3,
                "selfReportQ" to listJawaban,
                "selfReportQHasil" to cekSelfReportResult()
            )
            mDB.runBatch {
                it.update(reffUser, docData as Map<String, Any>)
            }.addOnCompleteListener {
                dialog.dismiss()
                if (it.isSuccessful) {
                    startActivity(Intent(this, ThankYou::class.java))
                    finish()
                }
            }
        } else {
            soal.text = listSoalModel.get(counter).pertanyaan?.replace("\u2103", "\u2103")
            Glide.with(this).asDrawable().load(listSoalModel.get(counter).imageUrl)
                .error(R.drawable.item_pertanyaan).into(gambar)
            listSoalModel.get(counter).apply {
                val soalModel = this
                jawaban.forEach {
                    val jawaban = it
                    val button = MaterialButton(this@SelfReportQActivity).apply {
                        cornerRadius = 25
                        text = it.jawaban
                        setBackgroundColor(
                            ContextCompat.getColor(
                                this@SelfReportQActivity,
                                R.color.SecondKemenkes
                            )
                        )
                    }
                    button.setOnClickListener {
                        lyt_jawaban.removeAllViews()
                        listJawaban.add(
                            LogSkrinningModel.JawabanUser(
                                soalModel.id,
                                jawaban.jawaban
                            )
                        )
                        updateSoal(listSoalModel)
                    }
                    lyt_jawaban.addView(button)
                }
            }

        }
        counter++
    }

    fun cekSelfReportResult(): String {
        var isPerluPendamping = false
        var count = 0
        var jmlYa = 0
        while (count < 20) {
            if (jmlYa >= 7) {
                isPerluPendamping = true
                break
            }
            if (listJawaban.get(count).jawaban.equals("ya", true)) {
                jmlYa++
            }
            count++
        }
        var status = ""
        if (isPerluPendamping) {
            status += "perlu pendampingan psikologis,"
        }
        if (listJawaban.get(16).jawaban.equals("ya", true)) {
            status += "perlu konsultasi profesional,"
        }
        if (listJawaban.get(20).jawaban.equals("ya", true)) {
            status += "perilaku maladaptif penggunaan NAPZA,"
        }
        if (listJawaban.get(22).jawaban.equals("ya", true) ||
            listJawaban.get(23).jawaban.equals("ya", true)
        ) {
            status += "perlu asessment oleh profesional kesehatan jiwa,"
        }
        if (listJawaban.get(22).jawaban.equals("ya", true) ||
            listJawaban.get(23).jawaban.equals("ya", true) ||
            listJawaban.get(23).jawaban.equals("ya", true) ||
            listJawaban.get(23).jawaban.equals("ya", true)
        ) {
            status += "Early PTSD"
        }
        return status
    }
}
