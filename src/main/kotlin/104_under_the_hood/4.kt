package `104_under_the_hood`.s_4

import kotlinx.coroutines.delay

suspend fun a() {
    val user = readUser()
    b()
    b()
    b()
    println(user)
}
suspend fun b() {
    for (i in 1..10) {
        c(i)
    }
}
suspend fun c(i: Int) {
    delay(i * 10L)
    println("Tick-$i")
}

suspend fun readUser(): String {
    delay(1000)
    return "John"
}

suspend fun main() = a()
