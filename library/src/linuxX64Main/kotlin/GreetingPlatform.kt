package io.github.kotlin.greeting

import kotlinx.cinterop.*
import platform.posix.*

@OptIn(ExperimentalForeignApi::class)
actual fun currentHour(): Int {
    memScoped {
        val tVar = alloc<time_tVar>()
        time(tVar.ptr)
        val tmPtr = localtime(tVar.ptr) ?: error("Failed to get localtime")
        return tmPtr.pointed.tm_hour.toInt()
    }
}
