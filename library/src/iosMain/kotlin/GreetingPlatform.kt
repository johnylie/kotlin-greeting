package io.github.kotlin.greeting

import platform.Foundation.*

actual fun currentHour(): Int {
    val date = NSDate()
    val calendar = NSCalendar.currentCalendar
    return calendar.component(NSCalendarUnitHour, fromDate = date).toInt()
}
