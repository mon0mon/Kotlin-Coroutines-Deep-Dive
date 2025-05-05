package `201_coroutine_builders`.s_5

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() = runBlocking {
    val resultDeffered = GlobalScope.async {
        delay(1.toDuration(DurationUnit.SECONDS))
        42
    }

    //  do other stuff
    val result = resultDeffered.await()
    println(result) //  42
    //  or just
    println(resultDeffered.await()) // 42
}
