package `204_Cancellation`.s_1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Cancellation
 * Basic cancellation
 * pg.102
 */

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        repeat(1_000) { i ->
            delay(0.2.toDuration(DurationUnit.SECONDS))
            println("Printing $i")
        }
    }

    delay(1.1.toDuration(DurationUnit.SECONDS))
    job.cancel()
    job.join()
    println("Cancelled successfully")
}
