package io.github.kotlin.greeting

import kotlin.test.Test
import kotlin.test.assertTrue

class GreetingLinuxTest {
    @Test
    fun testLinuxGreet() {
        val result = greet(Language.EN)
        assertTrue(result.isNotEmpty())
    }
}
