package ublearntech.com.halopico.modul.selfreport

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_thank_you.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.model.SoalModel
import ublearntech.com.halopico.modul.MainActivity
import ublearntech.com.halopico.util.Const
import ublearntech.com.halopico.util.DBHelper

class ThankYou : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)
        val covid = intent.getBooleanExtra("isCovid", false)
        if (covid){
            btn_next.text="Lanjutkan Self-Reporting Questionnaire"
        }
    }

    fun processMain(view: View) {
        val covid = intent.getBooleanExtra("isCovid", false)
        if (covid) {
            val db=DBHelper.getDb()
            val builderdialog = AlertDialog.Builder(this)
            builderdialog.setCancelable(false)
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            builderdialog.setView(inflater.inflate(R.layout.progress, null))
            val dialog = builderdialog.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
            db.collection(Const.soal).whereEqualTo("tipe",4).get().addOnSuccessListener {
                dialog.dismiss()
                if (!it.isEmpty) {
                    val list = ArrayList<SoalModel>()
                    list.addAll(it.toObjects(SoalModel::class.java))
                    startActivity(
                        Intent(this, SelfReportQActivity::class.java)
                            .putExtra("listSoal", list)
                    )
                    finish()
                }
            }.addOnFailureListener {
                dialog.dismiss()
                Toast.makeText(
                    this,
                    it.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
        } else {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            )
            finish()
        }
    }
}
