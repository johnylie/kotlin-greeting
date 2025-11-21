package io.github.johnylie.kotlin.greeting

import kotlin.test.Test
import kotlin.test.assertTrue

class GreetingJvmTest {
    @Test
    fun testJvmGreet() {
        val result = greet(Language.ID)
        assertTrue(result.isNotEmpty())
    }
}
