package com.daveleeds.livestream.uuids

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
fun main() {
    val first = Uuid.parse("6f5e6045-09be-426a-8200-263d86525a36")
    val second = Uuid.parse("6f5e604509be426a8200263d86525a36")

    println(first == second)
}
