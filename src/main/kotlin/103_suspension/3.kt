package `103_suspension`.s_3

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")

    //  suspend coroutine
    suspendCoroutine<Unit> { continuation ->
        //  lambda that passed as parameter
        //  executes right before the suspension happens
        println("Before too")
    }

    println("After")
}

//  Before

//  After
