package `103_suspension`.s_13

import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

//  Do not do this
var continuation: Continuation<Unit>? = null

suspend fun suspendAndSetContinuation() {
    suspendCancellableCoroutine<Unit> { cont ->
        continuation = cont
    }
}

suspend fun main() {
    println("Before")

    suspendAndSetContinuation()
    continuation?.resume(Unit)

    println("After")
}
