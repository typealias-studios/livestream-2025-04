package com.daveleeds.livestream.atomics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.atomics.AtomicInt
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.concurrent.atomics.asJavaAtomic
import kotlin.concurrent.atomics.asKotlinAtomic
import kotlin.concurrent.atomics.plusAssign

@OptIn(ExperimentalAtomicApi::class)
fun main() {
    val counter = AtomicInt(0)

    runBlocking {
        repeat(100_000) {
            launch(Dispatchers.Default) { counter += 1 }
        }

        println(counter)
        val javaAtomic: AtomicInteger = counter.asJavaAtomic()
        val kotlinAtomic: AtomicInt = javaAtomic.asKotlinAtomic()

        // This actually works when uncommented:
        // println(javaAtomic === kotlinAtomic)
    }
}
