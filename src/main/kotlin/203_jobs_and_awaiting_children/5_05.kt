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
 * pg.99
 */

fun main() = runBlocking {
    val job = Job()

    launch(job) {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("Text 1")
    }

    launch {
        delay(2.toDuration(DurationUnit.SECONDS))
        println("Text 2")
    }

    job.complete()
    job.join()
}
