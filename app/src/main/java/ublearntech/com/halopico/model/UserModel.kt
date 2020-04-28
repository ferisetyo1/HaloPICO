package ublearntech.com.halopico.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.firebase.Timestamp
import com.google.firebase.firestore.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize

//user data status
//0 = belum isi data diri
//1 = belum isi self report
//2 = data lengkap
@Keep
@IgnoreExtraProperties
@Parcelize
class UserModel(
    var nama: String,
    var userName: String,
    var tglLahir: String,
    var kota: String,
    var provinsi: String,
    var nohp: String,
    var jenisKelamin: String,
    var pekerjaan: String,
    var riwayatPendidikan: String,
    var alamat: String,
    var kondisiPsikologis: String,
    var imgURL:String,
    var lastSkrinning: Timestamp,
    var regTime: Timestamp,
    var statusData: Int,
    var selfReportHasil:String,
    var selfReport:ArrayList<LogSkrinningModel.JawabanUser>
) : Parcelable {

    constructor() : this(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        Timestamp.now(),
        Timestamp.now(),
        -1,
        "",
        arrayListOf()
    )

    override fun toString(): String {
        return "UserModel(nama='$nama', userName='$userName', tglLahir='$tglLahir', kota='$kota', provinsi='$provinsi', nohp='$nohp', jenisKelamin='$jenisKelamin', pekerjaan='$pekerjaan', riwayatPendidikan='$riwayatPendidikan', alamat='$alamat', kondisiPsikologis='$kondisiPsikologis', imgURL='$imgURL', lastSkrinning=$lastSkrinning, regTime=$regTime, statusData=$statusData, selfReportHasil='$selfReportHasil', selfReport=$selfReport)"
    }


}