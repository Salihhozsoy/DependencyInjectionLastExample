package com.example.dependencyinjection.model

class Car(private val engine: Engine) {

    fun drive(){
        val isEngineRun =engine.start()
        println(isEngineRun)
    }
}