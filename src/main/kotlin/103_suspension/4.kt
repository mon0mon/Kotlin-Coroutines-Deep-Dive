package `103_suspension`.s_4

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")

    //  suspend coroutine
    suspendCoroutine<Unit> { continuation ->
        //  Never suspend because of the kotlin compiler optimization
        continuation.resume(Unit)
    }

    println("After")
}

//  Before

//  After
