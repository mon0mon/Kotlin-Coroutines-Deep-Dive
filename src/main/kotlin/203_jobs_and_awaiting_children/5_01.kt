package `203_jobs_and_awaiting_children`.s_5

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Part 2: Kotlin Coroutines library
 * Jobs and awaiting children
 * Job factory function
 * pg.95
 */

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {   // the new job replaces one from parent
        delay(1.toDuration(DurationUnit.SECONDS))
        println("Text 1")
    }
    launch(job) {   // the new job replaces one from parent
        delay(2.toDuration(DurationUnit.SECONDS))
        println("Text 2")
    }

    job.join()  // Here we will await forever
    println("Will not be printed")
}

//  (1 sec)
//  Text 1
//  (2 sec)
//  Text 2
//  (runs forever)
