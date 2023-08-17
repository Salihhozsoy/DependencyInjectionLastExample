package com.example.dependencyinjection.model

class DieselEngine:Engine {
    override fun start(): String {
      return "dizel çalıştı"
    }

    override fun stop(): String {
       return "dizel durud"
    }

    override fun isFault(): Boolean {
        TODO("Not yet implemented")
    }
}