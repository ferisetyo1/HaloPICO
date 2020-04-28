package ublearntech.com.halopico.modul.histori

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_history.view.*
import ublearntech.com.halopico.model.LogSkrinningModel
import ublearntech.com.halopico.util.Helper

class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tanggal = itemView.txt_tanggal
    var kondisi = itemView.txt_kondisi
    var btn_rek = itemView.btn_rek

    fun bind(histori: LogSkrinningModel) {
        tanggal.text=Helper.longtoDate(histori.tanggal.toDate())
        kondisi.text=histori.status
    }
}