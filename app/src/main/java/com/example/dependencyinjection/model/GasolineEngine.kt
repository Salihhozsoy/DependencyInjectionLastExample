package com.example.dependencyinjection.model

class GasolineEngine:Engine {
    override fun start(): String {
        return "gasoline çalıştı"
    }

    override fun stop(): String {
        return "gasoline durdu"
    }

    override fun isFault(): Boolean {
        TODO("Not yet implemented")
    }
}