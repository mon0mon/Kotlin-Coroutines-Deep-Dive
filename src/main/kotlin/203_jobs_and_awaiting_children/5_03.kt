package `203_jobs_and_awaiting_children`.s_5

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Jobs and awaiting children
 * Job factory function
 * pg.97
 */

fun main() = runBlocking {
    val job = Job()

    launch(job) {
        repeat(5) { num ->
            delay(0.2.toDuration(DurationUnit.SECONDS))
            println("Rep$num")
        }
    }

    launch {
        delay(0.5.toDuration(DurationUnit.SECONDS))
        job.complete()
    }

    job.join()

    launch(job) {
        println("Will not be printed")
    }

    println("Done")
}
