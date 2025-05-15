package `204_Cancellation`.s_1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Cancellation
 * Basic cancellation
 * pg.103
 */

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        repeat(1_000) { i ->
            delay(0.1.toDuration(DurationUnit.SECONDS))
            Thread.sleep(Duration.ofMillis(100))
            println("Printing $i")
        }
    }

    delay(1.toDuration(DurationUnit.SECONDS))
    job.cancel()
    job.join()
    println("Cancelled successfully")
}
