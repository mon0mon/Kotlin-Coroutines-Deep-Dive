package `204_Cancellation`.s_2

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Cancellation
 * Just one more call
 * pg.107
 */

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(2.toDuration(DurationUnit.SECONDS))
            println("Job is done")
        } finally {
            println("Finally")
            launch {
                println("Will not be printed")
            }
            delay(1.toDuration(DurationUnit.SECONDS))   // here exception is thrown
            println("Will not be printed")
        }
    }

    delay(1.toDuration(DurationUnit.SECONDS))
    job.cancelAndJoin()
    println("Cancel done")
}
