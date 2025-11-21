package io.github.johnylie.kotlin.greeting

import java.util.Calendar

actual fun currentHour(): Int {
    return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
}
