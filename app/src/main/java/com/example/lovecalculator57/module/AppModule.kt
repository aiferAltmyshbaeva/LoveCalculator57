package com.example.lovecalculator57.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.lovecalculator57.Presenter
import com.example.lovecalculator57.model.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

//    @Provides
//    fun provideSharedPreferences(application: Application): SharedPreferences {
//        return application.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
//    }

}