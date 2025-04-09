package com.daveleeds.livestream.atomics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.atomics.ExperimentalAtomicApi

@OptIn(ExperimentalAtomicApi::class)
fun main() {
    val letters = 'a'..'e'
    var counter = IntArray(5) { 0 }

    runBlocking {
        text.lowercase().forEach { char ->
            val index = letters.indexOf(char)
            if (index >= 0) {
                launch(Dispatchers.Default) {
                    counter[index] = counter[index] + 1
                }
            }
        }
    }

    for (i in 0..<5) {
        println(counter[i])
    }
}

private val text = """
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris rutrum orci vitae ullamcorper bibendum. Aliquam 
venenatis ex vel nunc aliquet, at porttitor elit consectetur. Pellentesque porttitor nulla turpis, sed commodo enim 
egestas et. In hac habitasse platea dictumst. Nullam tincidunt in lacus eu cursus. Nullam pharetra nec ipsum at congue. 
Aenean auctor luctus nisi, vel pharetra ipsum blandit vitae.
""".repeat(1000).trimIndent()
