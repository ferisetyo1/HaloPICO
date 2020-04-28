package ublearntech.com.halopico.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.firebase.firestore.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize

@Keep
@IgnoreExtraProperties
@Parcelize
class PakarModel(
    val nama: String,
    val tempat: String,
    val noHp: String,
    val imgUrl: String
) : Parcelable {
    constructor() : this("", "", "", "")

    override fun toString(): String {
        return "PakarModel(nama='$nama', tempat='$tempat', noHp='$noHp', imgUrl='$imgUrl')"
    }

}