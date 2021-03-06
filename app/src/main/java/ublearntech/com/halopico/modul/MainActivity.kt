package ublearntech.com.halopico.modul

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.data.Data
import ublearntech.com.halopico.modul.autentikasi.LoginActivity
import ublearntech.com.halopico.util.Const
import ublearntech.com.halopico.util.DBHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (FirebaseAuth.getInstance().currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        val mdb= DBHelper.getDb()
        mdb.collection(Const.Pakar).get().addOnSuccessListener {
            if (it.isEmpty){
                val batch=mdb.batch()
                Data.getDataPakar().forEach {
                    batch.set(
                        mdb.collection(Const.Pakar).document(),
                        it
                    )
                }
                batch.commit().addOnCompleteListener {
                    Log.d("input pakar","SUCCESS")
                }
            }
        }
        mdb.collection(Const.soal).get().addOnSuccessListener {
            if (it.isEmpty){
                val batch=mdb.batch()
                Data.getDataSoalString().forEach {
                    batch.set(
                        mdb.collection(Const.soal).document(it.id),
                        it
                    )
                }
                batch.commit().addOnCompleteListener {
                    Log.d("input soal","SUCCESS")
                }
            }
        }
        val nav_controller = findNavController(R.id.nav_view)
        bottomNavigationView.setupWithNavController(nav_controller)
    }
}
