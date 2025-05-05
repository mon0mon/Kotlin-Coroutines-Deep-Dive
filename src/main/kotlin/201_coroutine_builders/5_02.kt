package `201_coroutine_builders`.s_5

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() = runBlocking {
    val res1 = GlobalScope.async {
        delay(1.toDuration(DurationUnit.SECONDS))
        "Text 1"
    }
    val res2 = GlobalScope.async {
        delay(3.toDuration(DurationUnit.SECONDS))
        "Text 2"
    }
    val res3 = GlobalScope.async {
        delay(2.toDuration(DurationUnit.SECONDS))
        "Text 3"
    }
    println(res1.await())
    println(res2.await())
    println(res3.await())
}

// (1 sec)
// Text 1
// (2 sec)
// Text 2
// Text 3
