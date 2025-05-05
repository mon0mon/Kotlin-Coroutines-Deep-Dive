package `201_coroutine_builders`.s_3

import java.time.Duration

fun main() {
    Thread.sleep(Duration.ofSeconds(1))
    println("World!")
    Thread.sleep(Duration.ofSeconds(1))
    println("World!")
    Thread.sleep(Duration.ofSeconds(1))
    println("World!")
    println("Hello, ")
}
