package feri.com.halopico.modul.dialog

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import feri.com.halopico.R
import feri.com.halopico.data.Data
import feri.com.halopico.modul.ZoomingImage
import kotlinx.android.synthetic.main.bottom_sheet_recomm.*

/**
 * A simple [Fragment] subclass.
 */
class dialog_rekomendasi(val kondisi: String) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bottom_sheet_recomm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        video.setOnClickListener {
            val id = Data.ytKondisigetid(kondisi)
            if (!id.isNullOrEmpty()) {
                val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
                val webIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v=$id")
                )
                try {
                    requireContext().startActivity(appIntent)
                } catch (ex: ActivityNotFoundException) {
                    requireContext().startActivity(webIntent)
                }
            } else {
                Toast.makeText(requireContext(), "Konteks tidak tersedia", Toast.LENGTH_LONG).show()
            }
        }
        foto.setOnClickListener {
            val id = Data.kondisifotoUrl(kondisi)
            startActivity(Intent(requireContext(),ZoomingImage::class.java).apply {
                putExtra("imgid",id)
                putExtra("title",kondisi)
            })
        }
    }


}
