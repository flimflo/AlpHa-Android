package com.flimflo.alpha

enum class EndpointEnviroment(val endpoint: String) {
    UNKNOWN("unknown"),
    SATURDAY("https://evening-dusk-95063.herokuapp.com"),
    SUNDAY("https://dry-harbor-29135.herokuapp.com"),
}

object Enviroment {

    init {
        println("EndpointEnviroment Singleton class invoked.")
    }

    var currentEnviroment: EndpointEnviroment = EndpointEnviroment.UNKNOWN

    fun setEnviroment(enviroment: EndpointEnviroment){
        currentEnviroment = enviroment
    }

    fun getEnviroment(): String {
        return currentEnviroment.endpoint
    }
}