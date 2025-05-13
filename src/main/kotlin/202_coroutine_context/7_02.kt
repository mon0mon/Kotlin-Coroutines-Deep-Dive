package `202_coroutine_context`.s_7_2

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun CoroutineScope.log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

fun main() = runBlocking(CoroutineName("main")) {
    log("Started")
    val v1 = async(CoroutineName("c1")) {
        delay(0.5.toDuration(DurationUnit.SECONDS))
        log("Running async")
        42
    }

    launch(CoroutineName("c2")) {
        delay(1.toDuration(DurationUnit.SECONDS))
        log("Running launch")
    }

    log("The answer is ${v1.await()}")
}

// [main] Started
// (0.5 second later)
// [c1] Running async
// [main] The answer is 42
// (1 second later)
// [c2] Running launch
