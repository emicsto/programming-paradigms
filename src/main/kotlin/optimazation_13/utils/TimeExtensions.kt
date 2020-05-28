package optimazation_13.utils

import java.util.concurrent.TimeUnit

fun Long.formatToTimeString(): String{
    return when {
        this > 30000000000 -> "${TimeUnit.NANOSECONDS.toSeconds(this)} sekund"
        this > 30000000 -> "${TimeUnit.NANOSECONDS.toMillis(this)} milisekund"
        else -> "$this nanosekund"
    }
}