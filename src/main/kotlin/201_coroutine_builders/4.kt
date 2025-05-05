package `201_coroutine_builders`

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() = runBlocking {
    GlobalScope.launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    GlobalScope.launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    GlobalScope.launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    println("Hello, ")
    delay(2.toDuration(DurationUnit.SECONDS))
}
