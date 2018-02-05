package com.luthfihariz.homemade.di

import com.luthfihariz.homemade.main.MainActivity
import com.luthfihariz.homemade.main.MainComponent
import com.luthfihariz.homemade.main.MainModule
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * Created by luthfihariz on 02/02/18.
 */

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun plus(mainModule: MainModule): MainComponent
}