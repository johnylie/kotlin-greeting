package io.github.kotlin.greeting

import kotlin.test.Test
import kotlin.test.assertTrue

class GreetingAndroidTest {
    @Test
    fun testAndroidGreet() {
        val result = greet(Language.ID)
        assertTrue(result.isNotEmpty())
    }
}
