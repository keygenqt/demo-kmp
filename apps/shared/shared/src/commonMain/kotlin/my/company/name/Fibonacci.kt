package my.company.name

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Returns a list of Fibonacci numbers up to the specified count.
 *
 * @param count The number of Fibonacci numbers to generate.
 * @return A list of Fibonacci numbers.
 * @throws IllegalArgumentException if count is less than zero.
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
fun getFibonacciNumbers(count: Int): String {
    require(count >= 0)
    val result = mutableListOf<Int>()

    if (count == 0) return result.toString()

    var t1 = 0
    var t2 = 1
    for (i in 1..count) {
        result.add(t1)
        val sum = t1 + t2
        t1 = t2
        t2 = sum
    }

    return result.toString()
}
