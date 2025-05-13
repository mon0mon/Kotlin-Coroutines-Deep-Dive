package `203_jobs_and_awaiting_children`.s_3

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Jobs and awaiting children
 * Coroutine builders create their jobs based on their parent job
 * pg.93
 */

fun main(): Unit = runBlocking {
    launch(Job()) { // the new job replaces one from parent
        delay(1.toDuration(DurationUnit.SECONDS))
        println("Will not be printed")
    }
}
// (prints nothing, finishes immediately)
