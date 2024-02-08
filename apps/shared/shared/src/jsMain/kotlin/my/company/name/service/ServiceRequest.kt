package my.company.name.service

import io.ktor.client.*
import io.ktor.client.engine.js.*
import my.company.name.service.impl.GetRequestJS

/**
 * Get platform JS client
 */
actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Js) {
    config(this)
}

/**
 * JS service network
 */
@JsExport
@OptIn(ExperimentalJsExport::class)
class ServiceRequestJS {
    private val request = ServiceRequest()

    val get by lazy { GetRequestJS(request, false) }
    val getEvent by lazy { GetRequestJS(request, true) }
}
