package ublearntech.com.halopico.modul.histori

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_history.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.model.LogSkrinningModel
import ublearntech.com.halopico.modul.dialog.dialog_rekomendasi
import ublearntech.com.halopico.util.Const
import ublearntech.com.halopico.util.DBHelper

class HistoryActivity : AppCompatActivity() {

    private var rv_option: FirestoreRecyclerOptions<LogSkrinningModel>? = null
    private var rv_adapter: FirestoreRecyclerAdapter<LogSkrinningModel, HistoryViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val query = DBHelper.getDb().collection(Const.HS)
            .whereEqualTo("user_id", FirebaseAuth.getInstance().currentUser?.uid!!)
            .orderBy("tanggal",Query.Direction.DESCENDING)
        rv_option = FirestoreRecyclerOptions.Builder<LogSkrinningModel>()
            .setQuery(query, LogSkrinningModel::class.java)
            .build()

        rv_adapter = setAdapter()
        rv_history.adapter = rv_adapter
        rv_history.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_adapter?.startListening()
    }

    private fun setAdapter(): FirestoreRecyclerAdapter<LogSkrinningModel, HistoryViewHolder>? =
        object : FirestoreRecyclerAdapter<LogSkrinningModel, HistoryViewHolder>(rv_option!!) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_history, parent, false)

                return HistoryViewHolder(view)
            }

            override fun onBindViewHolder(p0: HistoryViewHolder, p1: Int, p2: LogSkrinningModel) {
                p0.bind(p2)
                p0.btn_rek.setOnClickListener {
                    val bts = dialog_rekomendasi(p2.status)
                    bts.show(supportFragmentManager, "dialogRekomendasi")
                }
            }

        }

    override fun onResume() {
        super.onResume()
        rv_adapter?.startListening()
    }

    override fun onPause() {
        super.onPause()
        rv_adapter?.stopListening()
    }

    fun back(view: View) {
        onBackPressed()
    }
}
