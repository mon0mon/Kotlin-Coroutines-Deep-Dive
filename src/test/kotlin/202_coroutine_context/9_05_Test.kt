package `202_coroutine_context`.s_9

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Test_9_05 {

    @Test
    fun test() = runTest {
        withContext(FakeUuidProviderContext("FAKE_UUID")) {
            val actual = makeUser("Michal")
            println(actual) // User(id=FAKE_UUID, name=Michal)
            Assertions.assertThat(actual).isEqualTo(User("FAKE_UUID", "Michal"))
        }
    }

    @Test
    fun test2() = runTest {
        CoroutineScope(FakeUuidProviderContext("FAKE_UUID")).launch {
            val actual = makeUser("Michal")
            println(actual) // User(id=FAKE_UUID, name=Michal)
            Assertions.assertThat(actual).isEqualTo(User("FAKE_UUID", "Michal"))
        }
    }
}
