package com.luthfihariz.homemade.main

import com.luthfihariz.homemade.data.RecipeRepository
import com.luthfihariz.homemade.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by luthfihariz on 04/02/18.
 */
@Module
class MainModule(private val activity: MainActivity) {


    @Provides
    @ActivityScope
    fun provideMainActivity(): MainActivity = activity

    @Provides
    @ActivityScope
    fun provideMainpresenter(repository: RecipeRepository, view: MainActivity): MainPresenter = MainPresenter(repository, view)
}