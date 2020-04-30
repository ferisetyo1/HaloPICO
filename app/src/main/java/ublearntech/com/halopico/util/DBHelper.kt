package ublearntech.com.halopico.util

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class DBHelper {
    companion object {
        private val db = FirebaseFirestore.getInstance()

        init {
            db.firestoreSettings = FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build()
        }

        fun getDb() = db

    }
}