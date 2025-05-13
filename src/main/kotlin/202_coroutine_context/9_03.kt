package `202_coroutine_context`.s_9

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("[1] Main Test-1")
    launch {
        println("[3] Launch Scope Test-1")
        launch {
            println("[4] Launch Scope Test-2")
        }
        launch {
            println("[5] Launch Scope Test-3")
            println("[6] Launch Scope Test-4")
            launch {
                println("[7] Launch Scope Test-5")
            }
        }
    }
    println("[2] Main Test-2")
}
