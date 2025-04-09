package com.daveleeds.livestream.atomics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.atomics.AtomicReference
import kotlin.concurrent.atomics.ExperimentalAtomicApi

@OptIn(ExperimentalAtomicApi::class)
fun main() {
    var text = AtomicReference("")

    runBlocking {
        repeat(100_000) {
            launch(Dispatchers.Default) {
                var tryAgain = true

                while (tryAgain) {
                    val current = text.load()
                    val success = text.compareAndSet(current, "${current}X")
                    tryAgain = !success
                }
            }
        }
    }

    println(text.load().length)
}
