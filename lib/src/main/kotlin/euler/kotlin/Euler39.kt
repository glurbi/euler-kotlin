package euler.kotlin

import kotlin.system.measureTimeMillis

object Euler39 {
    fun euler39(): String {
        var pMax = 0
        var solMax = 0
        (1..1000).forEach { p ->
            print("p=${p} ")
            var solCount = 0
            (1..p - 2).forEach { a ->
                (1..p - a - 1).forEach { b ->
                    val c = p - a - b
                    if (a * a == b * b + c * c) {
                        print("{$a,$b,$c}")
                        solCount++
                    }
                }
            }
            if (solCount > solMax) {
                solMax = solCount
                pMax = p
            }
            println()
        }
        return "$pMax,$solMax"
    }

}

fun main() {
    measureTimeMillis {
        println("answer: ${Euler39.euler39()}")
    }.also { println("Execution time is ${it} milliseconds") }
}
