package ublearntech.com.halopico.modul.lihatselfreport

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Source
import kotlinx.android.synthetic.main.activity_lihat_self_report.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.model.SoalModel
import ublearntech.com.halopico.model.UserModel
import ublearntech.com.halopico.modul.selfreport.SelfReportCovidActivity
import ublearntech.com.halopico.util.Const
import ublearntech.com.halopico.util.DBHelper

class LihatSelfReport : AppCompatActivity() {

    private lateinit var dialog: AlertDialog
    val db = DBHelper.getDb()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_self_report)

        val builderdialog = AlertDialog.Builder(this)
        builderdialog.setCancelable(false)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        db.collection(Const.user)
            .document(FirebaseAuth.getInstance().currentUser!!.uid).get(Source.CACHE)
            .addOnSuccessListener {
                val user = it.toObject(UserModel::class.java)
                var count = 1
                user!!.selfReportCovid.forEach {
                    val jawabanModel = it
                    Log.d("print", it.idSoal)
                    val textView = TextView(this)
                    textView.textSize=14f
                    textView.text = "${count++}."
                    db.collection(Const.soal)
                        .document(jawabanModel.idSoal).get(Source.CACHE).addOnSuccessListener {
                            var soal = "${textView.text} ${it.getString("pertanyaan")}"
                            val jwb = jawabanModel.jawaban
                            val builder=SpannableStringBuilder()
                            val str1=SpannableString(soal)
                            val str2=SpannableString(" "+jwb)
                            str2.setSpan(StyleSpan(Typeface.BOLD),0,str2.length,0)
                            builder.append(str1)
                            builder.append(str2)
                            textView.setText(builder)
                        }.addOnFailureListener {
                            dialog.dismiss()
                            it.printStackTrace()
                        }
                    lyt_SelfC.addView(textView)
                }
                count = 1
                user!!.selfReportQ.forEach {
                    val jawabanModel = it
                    Log.d("print", it.idSoal)
                    val textView = TextView(this)
                    textView.text = "${count++}."
                    db.collection(Const.soal)
                        .document(jawabanModel.idSoal).get(Source.CACHE).addOnSuccessListener {
                            dialog.dismiss()
                            var soal = "${textView.text} ${it.getString("pertanyaan")}"
                            val jwb = jawabanModel.jawaban
                            val builder=SpannableStringBuilder()
                            val str1=SpannableString(soal)
                            val str2=SpannableString(" "+jwb)
                            str2.setSpan(StyleSpan(Typeface.BOLD),0,str2.length,0)
                            builder.append(str1)
                            builder.append(str2)
                            textView.setText(builder)
                        }.addOnFailureListener {
                            dialog.dismiss()
                            it.printStackTrace()
                        }
                    lyt_SelfQ.addView(textView)
                }
            }
    }

    fun back(view: View) {
        onBackPressed()
    }

    fun editSelf(view: View) {
        dialog.show()
        db.collection(Const.soal).whereEqualTo("tipe", 0).get()
            .addOnSuccessListener {
                dialog.dismiss()
                if (!it.isEmpty) {
                    val list = ArrayList<SoalModel>()
                    list.addAll(it.toObjects(SoalModel::class.java))
                    startActivity(
                        Intent(this, SelfReportCovidActivity::class.java)
                            .putExtra("listSoal", list)
                    )
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
