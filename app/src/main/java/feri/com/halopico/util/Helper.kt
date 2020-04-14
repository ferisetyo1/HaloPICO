package feri.com.halopico.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Helper {
    fun longtoDate(date:Date): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return formatter.format(date)
    }
}