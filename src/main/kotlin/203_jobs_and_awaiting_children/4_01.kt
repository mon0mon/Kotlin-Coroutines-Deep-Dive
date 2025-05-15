package `203_jobs_and_awaiting_children`.s_4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Jobs and awaiting children
 * Waiting for children
 * pg.94
 */

fun main(): Unit = runBlocking {
    val job1 = launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("Test1")
    }
    val job2 = launch {
        delay(2.toDuration(DurationUnit.SECONDS))
        println("Test2")
    }

    job1.join()
    job2.join()
    println("All tests are done")
}

// (1 sec)
// Test1
// (1 sec)
// Test2
// All tests are done
