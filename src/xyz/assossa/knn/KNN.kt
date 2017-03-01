package xyz.assossa.knn

import xyz.assossa.knn.components.ActivationFunction
import xyz.assossa.knn.components.NeuronNet

fun main(args: Array<String>) {
    val weights = listOf(listOf(listOf(0.8F, 0.2F), listOf(0.4F, 0.9F), listOf(0.3F, 0.5F)), listOf(listOf(0.3F, 0.5F, 0.9F)))
    var nn = NeuronNet(listOf(2, 3, 1), ActivationFunction.SIGMOID, weights)

    var result = nn.process(listOf(1F, 1F))
    for (i in result)
        println("$i")
}