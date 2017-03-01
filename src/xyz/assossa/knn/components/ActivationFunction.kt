package xyz.assossa.knn.components

enum class ActivationFunction {
    LINEAR {
        override val func = ::linear
    },
    SIGMOID {
        override val func = ::sigmoid
    },
    HYPERBOLIC_TANGENT {
        override val func = ::hyperbolicTangent
    };

    abstract val func: (fl: Float) -> Float
}

fun linear(fl: Float): Float {
    return fl
}

fun sigmoid(fl: Float): Float {
    return (1F / (Math.pow(Math.E, (-fl).toDouble()) + 1)).toFloat()
}

fun hyperbolicTangent(fl: Float): Float {
    return ((1 - Math.pow(Math.E, fl * -2.0)) / (Math.pow(Math.E, fl * 2.0) + 1)).toFloat()
}