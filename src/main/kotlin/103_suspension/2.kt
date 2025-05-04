package `103_suspension`.s_2

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")

    //  suspend coroutine
    suspendCoroutine<Unit> { }

    //  never execute
    println("After")
}

//  Before

//  After
