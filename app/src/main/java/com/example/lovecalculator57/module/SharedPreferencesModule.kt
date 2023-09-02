package com.example.lovecalculator57.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object SharedPreferencesModule {

    @Provides
    @ActivityScoped
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }
}