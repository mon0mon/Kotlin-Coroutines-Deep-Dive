package `103_suspension`.s_5

import java.time.Duration
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        thread {
            println("Suspended")
            Thread.sleep(Duration.ofSeconds(1))
            continuation.resume(Unit)
            println("Resumed")
        }
    }

    println("After")
}

/**
 * Before
 * Suspended
 * (1 second later)
 * After
 * Resumed
 */
