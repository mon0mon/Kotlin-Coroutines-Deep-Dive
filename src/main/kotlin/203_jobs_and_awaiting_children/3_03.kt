package `203_jobs_and_awaiting_children`.s_3

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
 * pg.92
 */

// extension
val CoroutineContext.job: Job
    get() = get(Job) ?: error("Current context doesn't ...")

// usage
fun main(): Unit = runBlocking {
    println(coroutineContext.job.isActive) // true
}
