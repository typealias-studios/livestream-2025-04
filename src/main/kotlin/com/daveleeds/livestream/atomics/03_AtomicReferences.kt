package com.daveleeds.livestream.atomics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    var text = ""

    runBlocking {
        repeat(100_000) {
            launch(Dispatchers.Default) {
                text = "${text}X"
            }
        }
    }

    println(text.length)
}
