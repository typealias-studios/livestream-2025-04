@file:OptIn(ExperimentalUuidApi::class, ExperimentalStdlibApi::class)

package com.daveleeds.livestream.uuids

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

fun main() {
    val uuid = Uuid.random()

    println(uuid.toString())
    println(uuid.toHexString())
    println(uuid.toHexDashString())

    val hexFormatter = HexFormat {
        upperCase = true
        bytes {
            bytesPerGroup = 4
            groupSeparator = ":"
        }
    }

    println(uuid.toByteArray().toHexString(hexFormatter))
}
