package feri.com.halopico.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.firebase.firestore.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize

//Soal tipe
//0 untuk selfReport
//1 untuk GHQ-12
//2 untuk GAD-7
//3 untuk PHQ-9
@Keep
@IgnoreExtraProperties
@Parcelize
class SoalModel(
    val id: String,
    val pertanyaan: String?,
    val tipe: Int,
    val imageUrl: String,
    val jawaban: ArrayList<JawabanModel>
) : Parcelable {

    constructor() : this("", "", -1, "", arrayListOf())

    @Keep
    @IgnoreExtraProperties
    @Parcelize
    class JawabanModel(
        val jawaban: String,
        val point: Int
    ) : Parcelable{

        constructor() : this("", -1)

        override fun toString(): String {
            return "JawabanModel(jawaban='$jawaban', point=$point)"
        }

    }

    override fun toString(): String {
        return "SoalModel(id='$id', pertanyaan=$pertanyaan, tipe=$tipe, imageUrl='$imageUrl', jawaban=$jawaban)"
    }

}