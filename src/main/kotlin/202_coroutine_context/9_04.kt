package `202_coroutine_context`.s_9

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("1. Start")
    launch {
        // delay(100)
        println("2. Child done")
    }
    println("3. End")
}
