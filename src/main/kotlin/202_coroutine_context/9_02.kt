package `202_coroutine_context`.s_9

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class CounterContext(
    private val name: String
) : CoroutineContext.Element {

    override val key: CoroutineContext.Key<*> = Key
    private var nextNumber = 0

    companion object Key : CoroutineContext.Key<CounterContext>

    fun printNext(id: String) {
        println("[$id] $name: $nextNumber")
        nextNumber++
    }
}

suspend fun printNext(id: String) {
    coroutineContext[CounterContext]?.printNext(id)
}

suspend fun main() = withContext(CounterContext("Outer")) {
    printNext("1") // Outer: 0
    launch {
        printNext("3") // Outer: 2
        launch {
            printNext("4") // Outer: 3
        }
        launch(CounterContext("Inner")) {
            printNext("5") // Inner: 0
            printNext("6") // Inner: 1
            launch {
                printNext("8") // Inner: 2
            }
        }
        launch {
            printNext("7") // Outer: 4
        }
    }
    printNext("2") // Outer: 1
}

// Outer: 0
// Outer: 1
// Outer: 2
// Outer: 3
// Inner: 0
// Inner: 1
// Inner: 2
