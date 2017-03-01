package xyz.assossa.knn.components

class NeuronNet(neuronsPerLayer: List<Int>, activationFunction: ActivationFunction) {

    private val activationFunction = activationFunction
    private var neuronLayers = List(neuronsPerLayer.size - 1, { i: Int -> NeuronLayer(neuronsPerLayer[i], neuronsPerLayer[i + 1]) })

    constructor(neuronsPerLayer: List<Int>, activationFunction: ActivationFunction, weights: List<List<List<Float>>>) : this(neuronsPerLayer, activationFunction) {
        this.neuronLayers = List(neuronsPerLayer.size - 1, { i: Int -> NeuronLayer(neuronsPerLayer[i], neuronsPerLayer[i + 1], weights[i]) })
    }

    fun process(inputs: List<Float>): List<Float> {
        var output = inputs
        neuronLayers.forEach({ nl: NeuronLayer -> output = runActivation(nl.process(output)) })
        return output
    }

    fun adjustWeights(adjustments: List<List<List<Float>>>) {
        neuronLayers.indices.forEach({ i: Int -> neuronLayers[i].adjustWeights(adjustments[i]) })
    }

    fun getWeights(): List<List<List<Float>>> {
        return List(neuronLayers.size, { i: Int -> neuronLayers[i].getWeights() })
    }

    private fun runActivation(outputs: List<Float>): List<Float> {
        return List(outputs.size, { i: Int -> activationFunction.func(outputs[i]) })
    }
}