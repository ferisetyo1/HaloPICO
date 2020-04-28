package ublearntech.com.halopico.modul

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.modul.autentikasi.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (FirebaseAuth.getInstance().currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        val mdb= FirebaseFirestore.getInstance()
//        mdb.collection(Const.Pakar).get().addOnSuccessListener {
//            if (it.isEmpty){
//                val batch=mdb.batch()
//                Data.getDataPakar().forEach {
//                    batch.set(
//                        mdb.collection(Const.Pakar).document(),
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
