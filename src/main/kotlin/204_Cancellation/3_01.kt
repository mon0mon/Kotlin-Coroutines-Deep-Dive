package `204_Cancellation`.s_3

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Cancellation
 * invokeOnCompletion
 * pg.108
 */

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        delay(1.toDuration(DurationUnit.SECONDS))
    }

    job.invokeOnCompletion { exception: Throwable? ->
        println("Finished")
    }

    delay(0.4.toDuration(DurationUnit.SECONDS))
    job.cancelAndJoin()
}
