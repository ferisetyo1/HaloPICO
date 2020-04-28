package ublearntech.com.halopico.modul.konsultasi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_pakar.view.*
import ublearntech.com.halopico.model.PakarModel


class PakarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nama=itemView.nama
    var tempat=itemView.tempat
    var btn_wa=itemView.btn_wa
    var foto=itemView.foto

    fun bind(model:PakarModel) {
        nama.text=model.nama
        tempat.text=model.tempat
    }
}