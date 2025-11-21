package io.github.kotlin.greeting

enum class Language {
    EN, ID
}

fun greet(language: Language = Language.ID): String {
    val hour = currentHour()
    return when (language) {
        Language.ID -> greetId(hour)
        Language.EN -> greetEn(hour)
    }
}

private fun greetId(hour: Int): String = when (hour) {
    in 4..10 -> "Selamat Pagi"
    in 11..14 -> "Selamat Siang"
    in 15..17 -> "Selamat Sore"
    in 18..20 -> "Selamat Malam"
    else -> "Selamat Malam"
}

private fun greetEn(hour: Int): String = when (hour) {
    in 4..10 -> "Good Morning"
    in 11..14 -> "Good Afternoon"
    in 15..17 -> "Good Evening"
    in 18..20 -> "Good Night"
    else -> "Good Night"
}

expect fun currentHour(): Int
