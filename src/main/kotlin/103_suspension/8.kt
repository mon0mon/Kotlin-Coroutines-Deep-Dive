package `103_suspension`.s_7

import java.time.Duration
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private val executor = Executors.newSingleThreadScheduledExecutor {
    Thread(it, "scheduler").apply { isDaemon = true }
}

suspend fun delay(timeMillis: Long): Unit = suspendCoroutine { cont ->
    executor.schedule({
        cont.resume(Unit)
    }, timeMillis, TimeUnit.MILLISECONDS)
}

suspend fun main() {
    println("Before")

    delay(1000)

    println("After")
}
