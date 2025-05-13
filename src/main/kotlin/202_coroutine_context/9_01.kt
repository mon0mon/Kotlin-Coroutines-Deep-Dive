package `202_coroutine_context`.s_9

import kotlin.coroutines.CoroutineContext

class MyCustomContext : CoroutineContext.Element {

    override val key: CoroutineContext.Key<*> = Key

    companion object Key : CoroutineContext.Key<MyCustomContext>
}
