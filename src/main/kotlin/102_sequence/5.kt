package `102_sequence`.s_5

import kotlin.random.Random

fun main() {
    val randomNumbers = randomNumbers()
    println("Random Numbers: ${randomNumbers.take(5).toList()}")

    val randomUniqueStrings = randomUniqueStrings(5)
    println("Random Unique Strings: ${randomUniqueStrings.take(5).toList()}")
}

fun randomNumbers(
    seed: Long = System.currentTimeMillis()
): Sequence<Int> = sequence {
    var random = Random(seed)
    while (true) {
        yield(random.nextInt())
    }
}

fun randomUniqueStrings(
    length: Int,
    seed: Long = System.currentTimeMillis()
): Sequence<String> = sequence {
    val random = Random(seed)
    val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    while (true) {
        val randomString = (1..length)
            .map { i ->  random.nextInt(charPool.size) }
            .map(charPool::get)
            .joinToString("")
        yield(randomString)
    }
}.distinct()
