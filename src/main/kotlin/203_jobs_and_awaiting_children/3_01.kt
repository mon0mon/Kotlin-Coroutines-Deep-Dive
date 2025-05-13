package `203_jobs_and_awaiting_children`.s_3

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Jobs and awaiting children
 * Coroutine builders create their jobs based on their parent job
 * pg.91
 */

fun main(): Unit = runBlocking {
    val job: Job = launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("Test")
    }
}
