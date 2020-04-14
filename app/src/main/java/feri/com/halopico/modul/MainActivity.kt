package feri.com.halopico.modul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import feri.com.halopico.R
import feri.com.halopico.modul.autentikasi.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (FirebaseAuth.getInstance().currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

//        val mdb=FirebaseFirestore.getInstance()
//        mdb.collection(Const.soal).get().addOnSuccessListener {
//            if (it.isEmpty){
//                val batch=mdb.batch()
//                Data.getDataSoalString().forEach {
//                    batch.set(
//                        mdb.collection(Const.soal).document(it.id),
//                        it
//                    )
//                }
//                batch.commit().addOnCompleteListener {
//                    Log.d("input soal","SUCCESS")
//                }
//            }
//        }
        val nav_controller = findNavController(R.id.nav_view)
        bottomNavigationView.setupWithNavController(nav_controller)
    }
}
