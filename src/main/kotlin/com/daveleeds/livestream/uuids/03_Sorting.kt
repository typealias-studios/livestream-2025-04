@file:OptIn(ExperimentalUuidApi::class)

package com.daveleeds.livestream.uuids

import com.github.f4b6a3.uuid.UuidCreator
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import kotlin.uuid.toKotlinUuid

fun main() = runBlocking<Unit> {
    val first = Uuid.randomV7()
    val second = Uuid.randomV7()
    val third = Uuid.randomV7()

    println("--------------------------------")

    val reversed = listOf(third, second, first)
    println(reversed.sorted())
}

private suspend fun Uuid.Companion.randomV7(): Uuid = UuidCreator
    .getTimeOrderedEpoch()
    .toKotlinUuid()
    .also(::println)
    .also { delay(1.seconds) }
