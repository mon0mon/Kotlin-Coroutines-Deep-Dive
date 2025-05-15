package `204_Cancellation`.s_1

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.Duration
import kotlin.random.Random
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Cancellation
 * Basic cancellation
 * pg.105
 */

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(Random.nextDouble(0.0, 2.0).toDuration(DurationUnit.SECONDS))
            println("Done")
        } finally {
            println("Will always be printed")
        }
    }

    delay(1.toDuration(DurationUnit.SECONDS))
    job.cancelAndJoin()
}
