package `201_coroutine_builders`.s_6

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() = runBlocking {
    this.launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    launch {
        delay(2.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    println("Hello, ")
}
