package `204_Cancellation`.s_2

import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Cancellation
 * Just one more call
 * pg.108
 */

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(2.toDuration(DurationUnit.SECONDS))
            println("Job is done")
        } finally {
            println("Finally")
            withContext(NonCancellable) {
                delay(1.toDuration(DurationUnit.SECONDS))
                println("Cleanup done")
            }
        }
    }

    delay(1.toDuration(DurationUnit.SECONDS))
    job.cancelAndJoin()
    println("Cancel done")
}
