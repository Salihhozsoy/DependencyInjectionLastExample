package com.example.dependencyinjection.data.di

import com.example.dependencyinjection.model.DieselEngine
import com.example.dependencyinjection.model.GasolineEngine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PrinterModule {

    @Provides
    @Singleton
    fun provideGasolineEngine() =GasolineEngine()

    @Provides
    @Singleton
    fun provideMDieselEngine() =DieselEngine()

}