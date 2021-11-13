package euler.kotlin

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.system.measureTimeMillis

fun main() {
    measureTimeMillis {
        val triangleNumbers = (1..1000).map { n -> n * (n + 1) / 2 }.toSet()
        val words = Files.readString(Path("p42_words.txt")).split(",")
            .map { w -> w.removePrefix("\"").removeSuffix("\"") }
        var count = 0
        words.forEach { word ->
            val value = word.map { c -> c.code - 'A'.code + 1 }.sum()
            if (triangleNumbers.contains(value)) count++
        }
        println(count)
    }.also { println("Execution time is ${it} milliseconds") }
}
