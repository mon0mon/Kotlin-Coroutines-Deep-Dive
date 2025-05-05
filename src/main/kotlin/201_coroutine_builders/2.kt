package `201_coroutine_builders`.s_2

import java.time.Duration
import kotlin.concurrent.thread

fun main() {
    thread(isDaemon = true) {
        Thread.sleep(Duration.ofSeconds(1))
        println("World!")
    }
    thread(isDaemon = true) {
        Thread.sleep(Duration.ofSeconds(1))
        println("World!")
    }
    thread(isDaemon = true) {
        Thread.sleep(Duration.ofSeconds(1))
        println("World!")
    }
    println("Hello, ")
    Thread.sleep(Duration.ofSeconds(2))
}
