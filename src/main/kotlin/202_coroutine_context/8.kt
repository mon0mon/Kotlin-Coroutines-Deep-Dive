package `202_coroutine_context`.s_8

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext
import kotlin.time.DurationUnit
import kotlin.time.toDuration

suspend fun printName() {
    println(coroutineContext[CoroutineName]?.name)
}

suspend fun main() = withContext(CoroutineName("Outer")) {
    printName()
    launch(CoroutineName("Inner")) {
        printName()
    }
    delay(10.toDuration(DurationUnit.MILLISECONDS))
    printName()
}

// Outer
// Inner
// Outer
