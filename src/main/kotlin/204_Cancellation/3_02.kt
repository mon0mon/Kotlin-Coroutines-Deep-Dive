package `204_Cancellation`.s_3

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Cancellation
 * invokeOnCompletion
 * pg.109
 */

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        delay(Random.nextDouble(0.0, 2.4).toDuration(DurationUnit.SECONDS))
        println("Finished")
    }

    delay(0.8.toDuration(DurationUnit.SECONDS))
    job.invokeOnCompletion { exception: Throwable? ->
        println("Will always be printed")
        println("The exception was: $exception")
    }

    delay(0.8.toDuration(DurationUnit.SECONDS))
    job.cancelAndJoin()
}
