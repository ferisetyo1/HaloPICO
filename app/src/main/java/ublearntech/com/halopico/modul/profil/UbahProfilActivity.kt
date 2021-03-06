package ublearntech.com.halopico.modul.profil

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_ubah_profil.*
import ublearntech.com.halopico.R
import ublearntech.com.halopico.data.Data
import ublearntech.com.halopico.model.UserModel
import ublearntech.com.halopico.util.Const
import ublearntech.com.halopico.util.DBHelper
import java.text.SimpleDateFormat
import java.util.*


class UbahProfilActivity : AppCompatActivity() {

    private val mDB = DBHelper.getDb()
    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_profil)

        val items_jk = listOf("Laki-Laki", "Perempuan")
        val adapter_jk = ArrayAdapter(
            this,
            R.layout.text_layout, items_jk
        )
        dropdown_jk.setAdapter(adapter_jk)
        val items_pendidikan = listOf("SD", "SMP", "SMA", "Sarjana","Magister","Doktor")
        val adapter_pendidikan = ArrayAdapter(
            this,
            R.layout.text_layout, items_pendidikan
        )
        dropdown_pendidikan.setAdapter(adapter_pendidikan)
        val items_pekerjaan = Data.getPekerjaan()
        val adapter_pekerjaan = ArrayAdapter(
            this,
            R.layout.text_layout, items_pekerjaan
        )
        dropdown_pekerjaan.setAdapter(adapter_pekerjaan)
        dropdown_pekerjaan.setOnItemClickListener { adapterView, view, i, l ->
            val text = (view as TextView).text.toString()
            if (text.equals("Tenaga Kesehatan")) {
                lyt_dropdown_teKes.visibility = View.VISIBLE
                et_lyt_institusi.visibility = View.VISIBLE
                val items_tekes = Data.getTenagaKesehatan()
                val adapter_tekes = ArrayAdapter(
                    this,
                    R.layout.text_layout, items_tekes
                )
                dropdown_tekes.setAdapter(adapter_tekes)
            } else {
                lyt_dropdown_teKes.visibility = View.GONE
                dropdown_tekes.setText("")
                et_lyt_institusi.visibility = View.GONE
                et_institusi.setText("")
            }
        }
        val items_provinsi = Data.getListProvinsi()
        val adapter_provinsi = ArrayAdapter(
            this,
            R.layout.text_layout, items_provinsi
        )
        dropdown_provinsi.setAdapter(adapter_provinsi)
        dropdown_provinsi.setOnItemClickListener { adapterView, view, i, l ->
            val items_kota = Data.getListKota((view as TextView).text.toString())
            val adapter_kota = ArrayAdapter(
                this,
                R.layout.text_layout, items_kota
            )
            dropdown_kota.setAdapter(adapter_kota)
        }
        val items_kota = Data.getListKota("Aceh")
        val adapter_kota = ArrayAdapter(
            this,
            R.layout.text_layout, items_kota
        )
        dropdown_kota.setAdapter(adapter_kota)
        et_tgllahir.setOnClickListener {
            setOnDate()
        }
        et_tgllahir.setOnFocusChangeListener { view, b ->
            if (view.isFocused) {
                setOnDate()
            }
        }

        val builderdialog = AlertDialog.Builder(this)
        builderdialog.setCancelable(false)
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        val dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        val curUser = mAuth.currentUser
        val reffUser = mDB.collection(Const.user).document(curUser?.uid!!)
        reffUser.get().addOnSuccessListener {
            dialog.dismiss()
            if (it.exists()) {
                val user = it.toObject(UserModel::class.java)
                et_fullname.setText(user!!.nama)
                et_tgllahir.setText(user.tglLahir)
                et_nohp.setText(user.nohp)
                dropdown_jk.setText(user.jenisKelamin, false)
                dropdown_pendidikan.setText(user.riwayatPendidikan, false)
                if(Data.getTenagaKesehatan().contains(user.pekerjaan)){
                    dropdown_pekerjaan.setText("Tenaga Kesehatan",false)
                    dropdown_tekes.setText(user.pekerjaan,false)
                    et_institusi.setText(user.institusi)
                    lyt_dropdown_teKes.visibility = View.VISIBLE
                    et_lyt_institusi.visibility = View.VISIBLE
                    val items_tekes = Data.getTenagaKesehatan()
                    val adapter_tekes = ArrayAdapter(
                        this,
                        R.layout.text_layout, items_tekes
                    )
                    dropdown_tekes.setAdapter(adapter_tekes)
                }else if(Data.getPekerjaan().contains(user.pekerjaan)){
                    dropdown_pekerjaan.setText(user.pekerjaan,false)
                }else{
                    dropdown_pekerjaan.setText("")
                }
                dropdown_provinsi.setText(user.provinsi, false)
                dropdown_kota.setText(user.kota, false)
                et_alamat.setText(user.alamat)
            }
        }.addOnFailureListener {
            dialog.dismiss()
        }
    }

    private fun setOnDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, y, m, d ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, y)
                calendar.set(Calendar.MONTH, m)
                calendar.set(Calendar.DAY_OF_MONTH, d)
                val myFormat = "dd-MM-yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
                et_tgllahir.setText(sdf.format(calendar.getTime()))
            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = Date().time
        dpd.show()
    }

    fun back(view: View) {
        onBackPressed()
    }

    fun processSimpan(view: View) {
        if (!cek_input()) {
            return
        }

        val builderdialog = AlertDialog.Builder(this)
        builderdialog.setCancelable(false)
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        builderdialog.setView(inflater.inflate(R.layout.progress, null))
        val dialog = builderdialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        val curUser = mAuth.currentUser
        val reffUser = mDB.collection(Const.user).document(curUser?.uid!!)
        mDB.runBatch {
            it.update(reffUser, "nama", et_fullname.text.toString())
            it.update(reffUser, "nohp", et_nohp.text.toString())
            it.update(reffUser, "tglLahir", et_tgllahir.text.toString())
            it.update(reffUser, "provinsi", dropdown_provinsi.text.toString())
            it.update(reffUser, "kota", dropdown_kota.text.toString())
            it.update(reffUser, "jenisKelamin", dropdown_jk.text.toString())
            it.update(reffUser, "riwayatPendidikan", dropdown_pendidikan.text.toString())
            it.update(
                reffUser, "pekerjaan", when (dropdown_pekerjaan.text.toString()) {
                    "Tenaga Kesehatan" -> dropdown_tekes.text.toString()
                    else -> dropdown_pekerjaan.text.toString()
                }
            )
            it.update(reffUser, "alamat", et_alamat.text.toString())
            it.update(reffUser, "institusi", et_institusi.text.toString())
        }.addOnCompleteListener {
            dialog.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(
                    this,
                    "Profil berhasil diubah",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            } else {
                Toast.makeText(
                    this,
                    it.exception?.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun cek_input(): Boolean {
        et_lyt_fullname.error = null
        et_lyt_nohp.error = null
        et_lyt_alamat.error = null
        et_tgllahir.error = null
        lyt_dropdown_kota.error = null
        lyt_dropdown_provinsi.error = null
        lyt_dropdown_pekerjaan.error = null
        lyt_dropdown_teKes.error = null
        lyt_dropdown_pendidikan.error = null
        lyt_dropdown_jk.error = null
        et_lyt_institusi.error = null

        if (et_fullname.text.isNullOrEmpty()) {
            et_fullname.requestFocus()
            et_lyt_fullname.error = "Harap isi field yang kosong"
            return false
        }

        if (et_nohp.text.isNullOrEmpty()) {
            et_nohp.requestFocus()
            et_lyt_nohp.error = "Harap isi field yang kosong"
            return false
        }

        if (et_tgllahir.text.isNullOrEmpty()) {
            et_tgllahir.requestFocus()
            et_lyt_tgllahir.error = "Harap isi field yang kosong"
            return false
        }

        if (dropdown_jk.text.isNullOrEmpty()) {
            dropdown_jk.requestFocus()
            lyt_dropdown_jk.error = "Harap isi field yang kosong"
            return false
        }

        if (dropdown_pendidikan.text.isNullOrEmpty()) {
            dropdown_pendidikan.requestFocus()
            lyt_dropdown_pendidikan.error = "Harap isi field yang kosong"
            return false
        }

        if (dropdown_pekerjaan.text.isNullOrEmpty()) {
            dropdown_pekerjaan.requestFocus()
            lyt_dropdown_pekerjaan.error = "Harap isi field yang kosong"
            return false
        }

        if (dropdown_pekerjaan.text.equals("Tenaga Kesehatan") && dropdown_tekes.text.isNullOrEmpty()) {
            dropdown_tekes.requestFocus()
            lyt_dropdown_teKes.error = "Harap isi field yang kosong"
            return false
        }
        if (dropdown_pekerjaan.text.equals("Tenaga Kesehatan") && et_institusi.text.isNullOrEmpty()) {
            dropdown_tekes.requestFocus()
            et_lyt_institusi.error = "Harap isi field yang kosong"
            return false
        }

        if (dropdown_provinsi.text.isNullOrEmpty()) {
            dropdown_provinsi.requestFocus()
            lyt_dropdown_provinsi.error = "Harap isi field yang kosong"
            return false
        }

        if (dropdown_kota.text.isNullOrEmpty()) {
            dropdown_kota.requestFocus()
            lyt_dropdown_kota.error = "Harap isi field yang kosong"
            return false
        }

        if (et_alamat.text.isNullOrEmpty()) {
            et_alamat.requestFocus()
            et_lyt_alamat.error = "Harap isi field yang kosong"
            return false
        }

        return true
    }
}
