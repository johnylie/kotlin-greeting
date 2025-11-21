package io.github.kotlin.greeting

import kotlin.test.Test
import kotlin.test.assertTrue

class GreetingIosTest {
    @Test
    fun testIosGreet() {
        val result = greet(Language.EN)
        assertTrue(result.isNotEmpty())
    }
}
