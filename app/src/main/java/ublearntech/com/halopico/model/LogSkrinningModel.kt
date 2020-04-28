package ublearntech.com.halopico.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.firebase.Timestamp
import com.google.firebase.firestore.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize

@Keep
@IgnoreExtraProperties
@Parcelize
class LogSkrinningModel(
    var id: String,
    var user_id: String,
    var tanggal: Timestamp,
    var status: String,
    var hasilSkrinning: ArrayList<HasilSkrinning>
) : Parcelable {

    constructor() : this("", "", Timestamp.now(), "", arrayListOf())

    @Keep
    @IgnoreExtraProperties
    @Parcelize
    class HasilSkrinning(
        val tipe: Int,
        val point: Int,
        val jawabanUser: ArrayList<JawabanUser>
    ) : Parcelable {
        constructor() : this(-1, -1, arrayListOf())
    }

    @Keep
    @IgnoreExtraProperties
    @Parcelize
    class JawabanUser(
        val idSoal: String,
        val jawaban: String
    ) : Parcelable{
        constructor():this("","")
    }
}