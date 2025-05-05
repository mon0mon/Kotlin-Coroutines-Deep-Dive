package `201_coroutine_builders`.s_3

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {
    runBlocking {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    runBlocking {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    runBlocking {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    println("Hello, ")
}
