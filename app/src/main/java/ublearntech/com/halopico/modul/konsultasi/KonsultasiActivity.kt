package ublearntech.com.halopico.modul.konsultasi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.activity_konsultasi.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.model.PakarModel
import ublearntech.com.halopico.util.Const
import ublearntech.com.halopico.util.DBHelper

class KonsultasiActivity : AppCompatActivity() {

    private var rv_option: FirestoreRecyclerOptions<PakarModel>? = null
    private var rv_adapter: FirestoreRecyclerAdapter<PakarModel, PakarViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konsultasi)

        val query = DBHelper.getDb().collection(Const.Pakar)
        rv_option = FirestoreRecyclerOptions.Builder<PakarModel>()
            .setQuery(query, PakarModel::class.java)
            .build()
        rv_adapter = setAdapter()
        rv_pakar.adapter = rv_adapter
        rv_pakar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_adapter?.startListening()
    }

    private fun setAdapter(): FirestoreRecyclerAdapter<PakarModel, PakarViewHolder>? =
        object : FirestoreRecyclerAdapter<PakarModel, PakarViewHolder>(rv_option!!) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PakarViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_pakar, parent, false)

                return PakarViewHolder(view)
            }

            override fun onBindViewHolder(
                holder: PakarViewHolder,
                position: Int,
                model: PakarModel
            ) {
                holder.bind(model)
                holder.btn_wa.setOnClickListener {
                    val url = "https://api.whatsapp.com/send?phone=+62" + model.noHp.substring(1);
                    val wa = Intent(Intent.ACTION_VIEW);
                    wa.setData(Uri.parse(url));
                    startActivity(wa);
                }
            }
        }

    fun back(view: View) {
        onBackPressed()
    }
}
