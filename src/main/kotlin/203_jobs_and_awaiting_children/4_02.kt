package `203_jobs_and_awaiting_children`.s_4

import kotlinx.coroutines.Job
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
    launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("Test1")
    }
    launch {
        delay(2.toDuration(DurationUnit.SECONDS))
        println("Test2")
    }

    val children = coroutineContext[Job]?.children

    val childrenNum = children?.count()
    println("Number of children : $childrenNum")
    children?.forEach { it.join() }
    println("All tests are done")
}

// Number of children: 2
// (1 sec)
// Test1
// (1 sec)
// Test2
// All tests are done
