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
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_self_report.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.model.LogSkrinningModel
import ublearntech.com.halopico.model.SoalModel
import ublearntech.com.halopico.util.Const

class SelfReportActivity : AppCompatActivity() {

    var counter = 0
    var listJawaban = ArrayList<LogSkrinningModel.JawabanUser>()
    val mDB = FirebaseFirestore.getInstance()

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
                "statusData" to 2,
                "selfReport" to listJawaban,
                "selfReportHasil" to cekSelfReportResult()
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
            soal.text = listSoalModel.get(counter).pertanyaan?.replace("\u2103","\u2103")
            listSoalModel.get(counter).apply {
                val soalModel = this
                jawaban.forEach {
                    val jawaban = it
                    val button = MaterialButton(this@SelfReportActivity).apply {
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
                        if (soalModel.id.equals("SR-011") && jawaban.jawaban.equals(
                                "tidak",
                                true
                            )
                        ) {
                            counter++
                        }
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
        if (
            (listJawaban.get(0).jawaban.equals("ya", true) ||
                    listJawaban.get(1).jawaban.equals("ya", true) ||
                    listJawaban.get(2).jawaban.equals("ya", true)) &&
            (listJawaban.get(3).jawaban.equals("tidak", true) &&
                    listJawaban.get(4).jawaban.equals("tidak", true) &&
                    listJawaban.get(5).jawaban.equals("tidak", true) &&
                    listJawaban.get(6).jawaban.equals("tidak", true) &&
                    listJawaban.get(7).jawaban.equals("tidak", true))
        ) {
            return "OTG"
        } else if (
            listJawaban.get(0).jawaban.equals("ya", true) &&
            listJawaban.get(1).jawaban.equals("ya", true) &&
            listJawaban.get(2).jawaban.equals("ya", true) &&
            listJawaban.get(3).jawaban.equals("ya", true) &&
            listJawaban.get(4).jawaban.equals("ya", true) &&
            listJawaban.get(5).jawaban.equals("ya", true) &&
            listJawaban.get(6).jawaban.equals("ya", true) &&
            listJawaban.get(7).jawaban.equals("ya", true)
        ) {
            if (listJawaban.get(8).jawaban.equals("ya", true) &&
                listJawaban.get(9).jawaban.equals("ya", true)
            ) {
                return "PDP"
            } else {
                return "ODP"
            }
        } else if (
            listJawaban.get(0).jawaban.equals("tidak", true) &&
            listJawaban.get(1).jawaban.equals("tidak", true) &&
            listJawaban.get(2).jawaban.equals("tidak", true) &&
            listJawaban.get(3).jawaban.equals("tidak", true) &&
            listJawaban.get(4).jawaban.equals("tidak", true) &&
            listJawaban.get(5).jawaban.equals("tidak", true) &&
            listJawaban.get(6).jawaban.equals("tidak", true) &&
            listJawaban.get(7).jawaban.equals("tidak", true) &&
            listJawaban.get(8).jawaban.equals("tidak", true) &&
            listJawaban.get(9).jawaban.equals("tidak", true)
        ) {
            return "tidak ada paparan"
        } else {
            return "tidak terdifinisi"
        }
    }
}
