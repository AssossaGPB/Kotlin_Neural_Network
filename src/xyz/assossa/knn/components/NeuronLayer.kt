package xyz.assossa.knn.components

class NeuronLayer(numberOfInputs: Int, numberOfNeurons: Int) {

    private var neurons = List(numberOfNeurons, { Neuron(numberOfInputs) })

    constructor(numberOfInputs: Int, numberOfNeurons: Int, weights: List<List<Float>>) : this(numberOfInputs, numberOfNeurons) {
        this.neurons = List(numberOfNeurons, { i: Int -> Neuron(numberOfInputs, weights[i]) })
    }

    fun process(inputs: List<Float>): List<Float> {
        return List(neurons.size, { i: Int -> neurons[i].process(inputs) })
    }

    fun adjustWeights(adjustments: List<List<Float>>) {
        neurons.indices.forEach({ i: Int -> neurons[i].adjustWeights(adjustments[i]) })
    }

    fun getWeights(): List<List<Float>> {
        return List(neurons.size, { i: Int -> neurons[i].getWeights() })
    }
}