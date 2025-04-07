package com.daveleeds.livestream.atomics

import kotlinx.coroutines.runBlocking

fun main() {
    var counter = 0

    runBlocking {
        repeat(100_000) {
            counter += 1
        }

        println(counter)
    }
}
