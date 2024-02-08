package my.company.name.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.asPromise
import kotlinx.coroutines.async
import my.company.name.Uuid
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun <T : Any> CoroutineScope.promiseWithEvent(
    enable: Boolean,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Any {
    return if (enable) {
        val caller = Uuid.v4()
        async(context, start, block).asPromise().then({
            sendEventResponse(caller = caller, response = it)
        }, {
            sendEventError(caller = caller, error = it.message ?: "Error query")
        })
        caller
    } else {
        async(context, start, block).asPromise()
    }
}

