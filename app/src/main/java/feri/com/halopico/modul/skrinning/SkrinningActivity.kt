package feri.com.halopico.modul.skrinning

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import feri.com.halopico.R
import feri.com.halopico.model.LogSkrinningModel
import feri.com.halopico.model.SoalModel
import feri.com.halopico.util.Const
import kotlinx.android.synthetic.main.activity_skrinning.*

class SkrinningActivity : AppCompatActivity() {

    private lateinit var dialog: AlertDialog
    var counter = 0
    var pointSkrinning = 0
    val mDB = FirebaseFirestore.getInstance()
    val curUser = FirebaseAuth.getInstance().currentUser
    val reffUser = mDB.collection(Const.user).document(curUser?.uid!!)
    var tipe = 0
    var listJawaban = ArrayList<LogSkrinningModel.JawabanUser>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skrinning)

        val listSoalModel = intent.getParcelableArrayListExtra<SoalModel>("listSoal")
        val builderdialog = AlertDialog.Builder(this)
        builderdialog.setCancelable(false)
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        tipe = listSoalModel.get(0).tipe
        when (tipe) {
            1 -> txt_title.text = "Skrinning General Health Questionnaire (GHQ – 12)"
            2 -> txt_title.text = "Skrinning Generalized Anxiety Disorder (GAD-7)"
            3 -> txt_title.text = "Skrinning Patient Health Questionnaire (PHQ-9)"
        }
        updateSoal(listSoalModel)
    }

    private fun updateSoal(
        listSoalModel: ArrayList<SoalModel>
    ) {
        if (listSoalModel.size <= counter) {
            if (tipe == 1) {
                if (pointSkrinning < 12) {
                    sendRekomendasi("Tidak ada perubahan", false, 1)
                } else if (pointSkrinning >= 12 && pointSkrinning <= 24) {
                    sendRekomendasi("Risiko gangguan psikologis", true, 2)
                } else {
                    sendRekomendasi("Perubahan kondisi psikologis", true, 3)
                }
            } else if (tipe == 2) {
                if (pointSkrinning < 10) {
                    sendRekomendasi("Khawatir", false, 4)
                } else {
                    sendRekomendasi("Khawatir", true, 4)
                }
            } else {
                sendRekomendasi("Sedih", false, 5)
            }
        } else {
            txt_soal.text = listSoalModel.get(counter).pertanyaan
            listSoalModel.get(counter).apply {
                val soalID = this.id
                jawaban.forEach { jawabanModel ->
                    val button = MaterialButton(this@SkrinningActivity).apply {
                        cornerRadius = 25
                        text = jawabanModel.jawaban
                        setBackgroundColor(
                            ContextCompat.getColor(
                                this@SkrinningActivity,
                                R.color.SecondKemenkes
                            )
                        )
                    }
                    button.setOnClickListener {
                        lyt_jawaban.removeAllViews()
                        updateSoal(listSoalModel)
                        pointSkrinning += jawabanModel.point
                        listJawaban.add(
                            LogSkrinningModel.JawabanUser(
                                soalID,
                                jawabanModel.jawaban
                            )
                        )
                    }
                    lyt_jawaban.addView(button)
                }
            }
        }
        counter++
    }

    private fun sendRekomendasi(kondisi: String, next: Boolean, rekomendasi: Int) {
        dialog.show()
        var reffHS = mDB.collection(Const.HS).document()
        val idDocHS = intent.getStringExtra("idResultRecent")
        Log.d("idDocHS", "'$idDocHS' thisisi")
        if (!idDocHS.isNullOrEmpty()) {
            reffHS = mDB.collection(Const.HS).document(idDocHS)
        }
        mDB.runBatch {
            it.update(reffUser, "kondisiPsikologis", kondisi)
            it.update(reffUser, "lastSkrinning", Timestamp.now())
            if (idDocHS.isNullOrEmpty()) {
                it.set(
                    reffHS,
                    LogSkrinningModel(
                        reffHS.id,
                        curUser?.uid!!,
                        Timestamp.now(),
                        kondisi,
                        arrayListOf(
                            LogSkrinningModel.HasilSkrinning(
                                tipe,
                                pointSkrinning,
                                listJawaban
                            )
                        )
                    )
                )
            } else {
                it.set(
                    reffHS,
                    hashMapOf(
                        "hasilSkrinning" to FieldValue.arrayUnion(
                            LogSkrinningModel.HasilSkrinning(
                                tipe,
                                pointSkrinning,
                                listJawaban
                            )
                        ),
                        "tanggal" to Timestamp.now(),
                        "status" to kondisi
                    ),
                    SetOptions.merge()
                )
            }
        }.addOnCompleteListener {
            dialog.dismiss()
            if (it.isSuccessful) {
                startActivity(
                    Intent(
                        this,
                        ResultSkrinningActivity::class.java
                    )
                        .putExtra("rekomendasi", rekomendasi)
                        .putExtra("kondisi", kondisi)
                        .putExtra("next", next)
                        .putExtra("idResultRecent", reffHS.id)
                )
                finish()
            } else {
                Toast.makeText(
                    this,
                    it.exception?.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun back(view: View) {
        onBackPressed()
    }
}
