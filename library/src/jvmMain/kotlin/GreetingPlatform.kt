package io.github.kotlin.greeting

import java.time.LocalTime

actual fun currentHour(): Int = LocalTime.now().hour
