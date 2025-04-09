@file:OptIn(ExperimentalUuidApi::class)

package com.daveleeds.livestream.uuids

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

fun main() {
    val uuid = Uuid.random()

    println(uuid.toString())
    println(uuid.toHexString())
    println(uuid.toHexDashString())
}
