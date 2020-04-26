package feri.com.halopico.util

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

object Helper {
    fun longtoDate(date:Date): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return formatter.format(date)
    }

    @Throws(IOException::class)
    fun getImage(url: URL): ByteArray? {
        val baos = ByteArrayOutputStream()
        val `is` = url.openStream()
        val b = ByteArray(4096)
        var n: Int
        while (`is`.read(b).also { n = it } > -1) {
            baos.write(b, 0, n)
        }
        return baos.toByteArray()
    }
}