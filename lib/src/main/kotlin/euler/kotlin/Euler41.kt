package euler.kotlin

import kotlin.math.ceil
import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

private fun isPandigit(x: Int): Boolean {
    val digits = x.toString().map { c -> c.code - '0'.code }.toList()
    return (1..digits.size).all { digits.contains(it) }
}

private fun isPrime(x: Int): Boolean {
    var i = 2
    val max = ceil(sqrt(x.toDouble())).toInt()
    while (i <= max) {
        if (x % i == 0)
            return false
        i++
    }
    return true
}

fun main() {
    measureTimeMillis {
        (3..987_654_321).forEach { i ->
            if (isPandigit(i) && isPrime(i)) {
                println(i)
            }
        }
    }.also { println("Execution time is ${it} milliseconds") }
}
