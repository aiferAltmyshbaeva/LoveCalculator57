package com.example.lovecalculator57.module

import com.example.lovecalculator57.Presenter
import com.example.lovecalculator57.ui.MainActivity
import com.example.lovecalculator57.view.LoveView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class InterfaceModule {

    @Binds
    abstract fun bindLoveView(activity: MainActivity):LoveView
}