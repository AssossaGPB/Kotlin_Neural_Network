package xyz.assossa.knn.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import xyz.assossa.knn.components.ActivationFunction
import xyz.assossa.knn.components.NeuronNet
import java.io.File
import java.io.Serializable

class NeuronNetSerializer {

    fun toFile(net: NeuronNet, path: String) {
        jacksonObjectMapper().writeValue(File(path), NeuronNetSerializable(net))
    }

    fun fromFile(path: String): NeuronNet {
        return jacksonObjectMapper().readValue<NeuronNetSerializable>(File(path)).createNet()
    }

    class NeuronNetSerializable(net: NeuronNet) : Serializable {
        val neuronsPerLayer = net.neuronsPerLayer
        val activationFunction = net.activationFunction.toString()
        val weights = net.getWeights()

        fun createNet(): NeuronNet {
            return NeuronNet(neuronsPerLayer, ActivationFunction.valueOf(activationFunction), weights)
        }
    }
}