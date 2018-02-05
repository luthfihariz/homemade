package com.luthfihariz.homemade.di

import android.content.Context
import com.luthfihariz.homemade.HomemadeApplication
import com.luthfihariz.homemade.data.RecipeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by luthfihariz on 02/02/18.
 */
@Module
class AppModule(private val application: HomemadeApplication) {

    @Provides
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideRecipeRepository(): RecipeRepository = RecipeRepository()
}