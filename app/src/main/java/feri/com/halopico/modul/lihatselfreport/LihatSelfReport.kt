package feri.com.halopico.modul.lihatselfreport

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import feri.com.halopico.R
import feri.com.halopico.model.SoalModel
import feri.com.halopico.model.UserModel
import feri.com.halopico.modul.selfreport.SelfReportActivity
import feri.com.halopico.util.Const
import kotlinx.android.synthetic.main.activity_lihat_self_report.*

class LihatSelfReport : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_self_report)
        val arrayTv = arrayListOf<TextView>(
            soal1,
            soal2,
            soal3,
            soal4,
            soal5,
            soal6,
            soal7,
            soal8,
            soal9,
            soal10,
            soal11,
            soal12
        )
        val builderdialog = AlertDialog.Builder(this)
        builderdialog.setCancelable(false)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        FirebaseFirestore.getInstance().collection(Const.user)
            .document(FirebaseAuth.getInstance().currentUser!!.uid).get(Source.CACHE)
            .addOnSuccessListener {
                val user = it.toObject(UserModel::class.java)
                if (user!!.selfReport.size == 11) {
                    soal12.visibility = View.GONE
                }
                user!!.selfReport.forEach {
                    val jawabanModel = it
                    Log.d("print", it.idSoal)

                    FirebaseFirestore.getInstance().collection(Const.soal)
                        .document(jawabanModel.idSoal).get(Source.CACHE).addOnCompleteListener {
                            if (it.isSuccessful){
                                var soal = it.result?.get("pertanyaan").toString()
                                if (jawabanModel.idSoal.equals("SR-004")) {
                                    soal = "Apakah anda demam diatas 38\u2103?"
                                }
                                if (jawabanModel.idSoal.equals("SR-012")&&user!!.selfReport.size == 12){
                                    dialog.dismiss()
                                }else if(jawabanModel.idSoal.equals("SR-011")&&user!!.selfReport.size == 11){
                                    dialog.dismiss()
                                }
                                val jwb = "<font color='#C5D72D'>${jawabanModel.jawaban}</font>"
                                arrayTv.get("${jawabanModel.idSoal.substring(4)}".toInt() - 1).text =
                                    Html.fromHtml(
                                        "${jawabanModel.idSoal.substring(4).toInt()}. $soal $jwb"
                                    )
                            }
                        }
                }
            }
    }

    fun back(view: View) {
        onBackPressed()
    }

    fun editSelf(view: View) {
        dialog.show()
        FirebaseFirestore.getInstance().collection(Const.soal).whereEqualTo("tipe", 0).get()
            .addOnSuccessListener {
                dialog.dismiss()
                if (!it.isEmpty) {
                    val list = ArrayList<SoalModel>()
                    list.addAll(it.toObjects(SoalModel::class.java))
                    startActivity(
                        Intent(this, SelfReportActivity::class.java)
                            .putExtra("listSoal", list)
                    )
                    finish()
                }
            }
            .addOnFailureListener {
                dialog.dismiss()
                Toast.makeText(
                    this,
                    it.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}
