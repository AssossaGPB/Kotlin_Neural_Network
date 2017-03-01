package xyz.assossa.knn.components

import java.util.*

class Neuron(numberOfInputs: Int) {

    private var weights = List(numberOfInputs, { Random().nextFloat() })

    constructor(numberOfInputs: Int, weights: List<Float>) : this(numberOfInputs) {
        this.weights = weights
    }

    fun process(inputs: List<Float>): Float {
        return weights.mapIndexed({ i: Int, fl: Float -> fl * weights[i] }).sum()
    }

    fun adjustWeights(adjustments: List<Float>) {
        weights = weights.mapIndexed({ i: Int, fl: Float -> fl + adjustments[i] })
    }

    fun getWeights(): List<Float> {
        return weights
    }
}