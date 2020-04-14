package feri.com.halopico.modul.histori

import android.content.ActivityNotFoundException
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import feri.com.halopico.R
import feri.com.halopico.data.Data
import feri.com.halopico.model.LogSkrinningModel
import feri.com.halopico.util.Const
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.bottom_sheet_recomm.view.*

class HistoryActivity : AppCompatActivity() {

    private var rv_option: FirestoreRecyclerOptions<LogSkrinningModel>? = null
    private var rv_adapter: FirestoreRecyclerAdapter<LogSkrinningModel, HistoryViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val query = FirebaseFirestore.getInstance().collection(Const.HS)
            .whereEqualTo("user_id", FirebaseAuth.getInstance().currentUser?.uid!!)
            .orderBy("tanggal",Query.Direction.DESCENDING)
        rv_option = FirestoreRecyclerOptions.Builder<LogSkrinningModel>()
            .setQuery(query, LogSkrinningModel::class.java)
            .build()

        rv_adapter = setAdapter()
        rv_history.adapter=rv_adapter
        rv_history.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_adapter?.startListening()
    }

    private fun setAdapter(): FirestoreRecyclerAdapter<LogSkrinningModel, HistoryViewHolder>? = object : FirestoreRecyclerAdapter<LogSkrinningModel, HistoryViewHolder>(rv_option!!){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_history, parent, false)

            return HistoryViewHolder(view)
        }

        override fun onBindViewHolder(p0: HistoryViewHolder, p1: Int, p2: LogSkrinningModel) {
            p0.bind(p2)
            p0.btn_rek.setOnClickListener {
                val bts = BottomSheetDialog(this@HistoryActivity)
                val parentView = layoutInflater.inflate(R.layout.bottom_sheet_recomm, null)
                parentView.video.setOnClickListener {
                    var id = Data.ytKondisigetid(
                        p2.status
                    )
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
                        Toast.makeText(this@HistoryActivity, "Konteks tidak tersedia", Toast.LENGTH_LONG).show()
                    }
                }
                parentView.foto.setOnClickListener {
                    var data = Data.kondisifotoUrl(
                        p2.status
                    )
                    val imageUri = (Uri.Builder())
                        .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                        .authority(resources.getResourcePackageName(R.drawable.kondisi1))
                        .appendPath(resources.getResourceTypeName(R.drawable.kondisi1))
                        .appendPath(resources.getResourceEntryName(R.drawable.kondisi1)+".png")
                        .build()
                    if (!data.isNullOrEmpty()) {
//                    val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath("kondisi1")
//                    val intent=Intent(Intent.ACTION_VIEW,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//                    intent.setDataAndType(Uri.parse("android.resource://feri.com.halopico/drawable/$data"),"image/*")
//                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    context!!.startActivity(intent)
//                    startActivity(
//                        Intent(
//                            Intent.ACTION_VIEW,
//                            imageUri
//                        ).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//                    )
                    } else {
                        Toast.makeText(this@HistoryActivity, "Konteks tidak tersedia", Toast.LENGTH_LONG).show()
                    }
                }
                bts.setContentView(parentView)
                bts.show()
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
