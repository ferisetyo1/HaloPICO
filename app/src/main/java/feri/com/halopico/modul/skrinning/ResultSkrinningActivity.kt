package feri.com.halopico.modul.skrinning

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import feri.com.halopico.R
import feri.com.halopico.data.Data
import feri.com.halopico.model.SoalModel
import feri.com.halopico.modul.MainActivity
import feri.com.halopico.modul.ZoomingImage
import feri.com.halopico.util.Const
import kotlinx.android.synthetic.main.activity_result_skrinning.*

class ResultSkrinningActivity : AppCompatActivity() {

    private var kondisi: String? = null
    private lateinit var dialog: AlertDialog
    private val mDB=FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_skrinning)
        kondisi = intent.getStringExtra("kondisi")
        val rekomendasi = intent.getIntExtra("rekomendasi", 1)
        val nextSkrinning = intent.getBooleanExtra("next", false)
        txt_kondisi.text = kondisi
        val builderdialog = AlertDialog.Builder(this)
        builderdialog.setCancelable(false)
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (nextSkrinning) {
            btn_nextSkrinning.visibility = View.VISIBLE
            btn_nextSkrinning.setOnClickListener {
                when (rekomendasi) {
                    2 -> {
                        getSkrinning(2)
                    }
                    3->{
                        getSkrinning(3)
                    }
                }
            }
        }
    }

    private fun getSkrinning(i: Int) {
        dialog.show()
        mDB.collection(Const.soal).whereEqualTo("tipe",i).get()
            .addOnSuccessListener {
                dialog.dismiss()
                if (!it.isEmpty) {
                    val list=ArrayList<SoalModel>()
                    val idDocHS=intent.getStringExtra("idResultRecent")
                    list.addAll(it.toObjects(SoalModel::class.java))
                    startActivity(
                        Intent(this, SkrinningActivity::class.java)
                            .putExtra("listSoal", list)
                            .putExtra("idResultRecent",idDocHS)
                    )
                } else {
                    Toast.makeText(
                        this,
                        "Konteks masih belum tersedia",
                        Toast.LENGTH_LONG
                    ).show()
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

    fun processMain(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun video(view: View) {
        val id = Data.ytKondisigetid(kondisi!!)
        if (!id.isNullOrEmpty()) {
            val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=$id")
            )
            try {
                startActivity(appIntent)
            } catch (ex: ActivityNotFoundException) {
                startActivity(webIntent)
            }
        } else {
            Toast.makeText(this, "Konteks tidak tersedia", Toast.LENGTH_LONG).show()
        }
    }

    fun foto(view: View) {
        val id = Data.kondisifotoUrl(kondisi!!)
        startActivity(Intent(this, ZoomingImage::class.java).apply {
            putExtra("imgid",id)
            putExtra("title",kondisi)
        })
    }
}
