package `204_Cancellation`.s_1

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
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
 * pg.104
 */

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        repeat(1_000) { i ->
            delay(0.2.toDuration(DurationUnit.SECONDS))
            println("Printing $i")
        }
    }

    delay(1.1.toDuration(DurationUnit.SECONDS))
    job.cancelAndJoin()
    println("Cancelled successfully")
}
