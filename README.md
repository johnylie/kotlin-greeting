# Kotlin Greeting Library

A simple Kotlin Multiplatform library for greeting messages based on the time of day and language.

---

Supported Languages

The library currently supports:

ID – Indonesian

EN – English

#### This is represented by the Language enum:

```kotlin
enum class Language {
    EN, ID
}
```

## Usage
### Basic greeting (default language is Indonesian)

```kotlin
import io.github.kotlin.greeting.*

fun main() {
    println(greet()) // e.g., "Selamat Pagi" if it's morning
}
```

### Greeting in English

```kotlin
import io.github.kotlin.greeting.*

fun main() {
    println(greet(Language.EN)) // e.g., "Good Morning" if it's morning
}
```

#### How it works

The greet() function determines the current hour using the platform-specific currentHour() function:

```kotlin
expect fun currentHour(): Int
```

- You need to implement currentHour() for each platform:

#### JVM / Android

```kotlin
actual fun currentHour(): Int {
    return java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
}
```

#### iOS

```kotlin
import platform.Foundation.*

actual fun currentHour(): Int {
    val date = NSDate()
    val calendar = NSCalendar.currentCalendar
    return calendar.component(NSCalendarUnitHour, date = date).toInt()
}
```

| Hour Range  | Indonesian    | English        |
| :---------- | :------------ | :------------- |
| `4-10`      | Selamat Pagi  | Good Morning   |
| `11-14`     | Selamat Siang | Good Afternoon |
| `15-17`     | Selamat Sore  | Good Evening   |
| `18-20`     | Selamat Malam | Good Night     |
| `Otherwise` | Selamat Malam | Good Night     |

## Installation

If published to Maven Central:

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.johnylie:kotlin-greeting:1.0.3")
}
```
