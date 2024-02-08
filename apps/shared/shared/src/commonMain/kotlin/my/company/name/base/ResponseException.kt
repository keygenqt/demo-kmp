package my.company.name.base

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Error response [Exception]
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
data class ResponseException(
    val code: Int,
    val error: String,
) : RuntimeException()
