package my.company.name

import my.company.name.extensions.sendEvent
import my.company.name.service.ServiceRequestJS

fun main() {}

/**
 * Js service HTTP request
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
val ServiceRequestReact = ServiceRequestJS()

/**
 * Init fun for run after ready index.html
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
fun init() = sendEvent("Init")

/**
 * NPM package for generate UUID
 */
@JsModule("uuid")
@JsNonModule
external object Uuid {
    fun v4(): String
}
