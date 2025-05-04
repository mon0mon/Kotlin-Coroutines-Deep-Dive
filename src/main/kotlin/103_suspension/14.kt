package `103_suspension`.s_14

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

//  Do not do this, potential memory leak
var continuation: Continuation<Unit>? = null

suspend fun suspendAndSetContinuation() {
    suspendCancellableCoroutine<Unit> { cont ->
        continuation = cont
        println("<top>.suspendAndSetContinuation")
    }
}

suspend fun main() = coroutineScope {
    println("Before")

    launch {
        delay(1000)
        println("<top>.main.launch")
        continuation?.resume(Unit)
    }

    suspendAndSetContinuation()

    println("After")
}

/**
 * Before
 * <top>.suspendAndSetContinuation
 * (1 second delay)
 * <top>.main.launch
 * After
 */
