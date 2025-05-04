package `103_suspension`.s_6

import java.time.Duration
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun continuationAfterSecond(continuation: Continuation<Unit>) {
    thread {
        Thread.sleep(Duration.ofSeconds(1))
        continuation.resume(Unit)
    }
}

suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        continuationAfterSecond(continuation)
    }

    println("After")
}
