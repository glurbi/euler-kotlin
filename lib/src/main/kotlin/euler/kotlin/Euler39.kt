package euler.kotlin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

object Euler39 {

    private fun perimeters() = (1..1000).asFlow()

    private fun countSolutions(p: Int): Flow<Pair<Int, Int>> = flow {
        var solCount = 0
        (1 until p - 2).forEach { a ->
            (1 until p - a).forEach { b ->
                val c = p - a - b
                if (a * a == b * b + c * c) {
                    solCount++
                }
            }
        }
        emit(Pair(p, solCount))
    }

    @FlowPreview
    suspend fun euler39() = withContext(Dispatchers.Default) {
        perimeters()
            .flatMapMerge { p -> countSolutions(p) }
            .reduce { acc, v -> if (acc.second < v.second) v else acc }
    }

}

@FlowPreview
fun main() {
    measureTimeMillis {
        runBlocking {
            println("answer: ${Euler39.euler39()}")
        }
    }.also { println("Execution time is ${it} milliseconds") }
}
