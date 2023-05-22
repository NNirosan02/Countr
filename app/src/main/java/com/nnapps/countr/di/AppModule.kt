package com.nnapps.countr.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.nnapps.countr.CounterInterface
import com.nnapps.countr.SharedPrefsHitOrMissCounter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("HitOrMissPreferences", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideHitOrMissCounter(sharedPreferences: SharedPreferences): CounterInterface {
        return SharedPrefsHitOrMissCounter(sharedPreferences)
    }
}
