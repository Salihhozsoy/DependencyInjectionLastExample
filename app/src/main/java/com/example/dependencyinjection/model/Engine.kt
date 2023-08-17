package com.example.dependencyinjection.model

interface Engine {

    fun start():String

    fun stop():String

    fun isFault():Boolean
}