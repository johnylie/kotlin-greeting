package io.github.johnylie.kotlin.greeting

import kotlin.test.Test
import kotlin.test.assertTrue

class GreetingTest {

    @Test
    fun testGreetReturnsNonEmpty() {
        assertTrue(greet(Language.ID).isNotEmpty())
        assertTrue(greet(Language.EN).isNotEmpty())
    }
}
