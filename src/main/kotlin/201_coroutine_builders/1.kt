package `201_coroutine_builders`.s_1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {
    GlobalScope.launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    GlobalScope.launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    GlobalScope.launch {
        delay(1.toDuration(DurationUnit.SECONDS))
        println("World!")
    }
    println("Hello, ")
    Thread.sleep(Duration.ofSeconds(2))
}
