package com.luthfihariz.homemade.main

import com.luthfihariz.homemade.di.scope.ActivityScope
import dagger.Component
import dagger.Subcomponent

/**
 * Created by luthfihariz on 04/02/18.
 */
@ActivityScope
@Subcomponent(modules = [(MainModule::class)])
interface MainComponent {

    fun inject(mainActivity: MainActivity): MainActivity
}
