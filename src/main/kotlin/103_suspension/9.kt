package `103_suspension`.s_9

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    val i = suspendCoroutine<Int> { cont ->
        cont.resume(42)
    }
    println(i)

    val str = suspendCoroutine<String> { cont ->
        cont.resume("Some text")
    }
    println(str)

    val b = suspendCoroutine<Boolean> { cont ->
        cont.resume(true)
    }
    println(b)
}
