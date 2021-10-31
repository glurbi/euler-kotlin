package euler.kotlin

import kotlin.system.measureTimeMillis

private fun digit(frac: String, n: Int) =
    frac.get(n - 1).code - '0'.code

fun main() {
    measureTimeMillis {

        val frac = StringBuilder(1_000_000).apply {
            var i = 0
            while (length < 1_000_000) {
                i++
                append(i)
            }
        }.toString()

        listOf(1, 10, 100, 1000, 10_000, 100_000, 1_000_000)
            .reduce { acc, v -> acc * digit(frac, v) }
            .also { println(it) }

    }.also { println("Execution time is ${it} milliseconds") }
}
