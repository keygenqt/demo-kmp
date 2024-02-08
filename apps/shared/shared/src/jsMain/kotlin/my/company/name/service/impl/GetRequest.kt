package my.company.name.service.impl


import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import my.company.name.extensions.promiseWithEvent
import my.company.name.service.ServiceRequest

@JsExport
@OptIn(ExperimentalJsExport::class)
@Suppress("unused", "NON_EXPORTABLE_TYPE")
class GetRequestJS(
    private val client: ServiceRequest,
    private val isEvent: Boolean
) {
    @OptIn(DelicateCoroutinesApi::class)
    fun repos() = GlobalScope.promiseWithEvent(isEvent) {
        client.get.repos().toTypedArray()
    }
}
