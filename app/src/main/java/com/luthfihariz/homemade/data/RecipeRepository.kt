package com.luthfihariz.homemade.data

import android.util.Log
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by luthfihariz on 12/5/17.
 */
class RecipeRepository() {

    private val edamamService: EdamamService

    init {
        val okHttpClient = OkHttpClient.Builder().addInterceptor(provideHttpLoggingInterceptor())

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.edamam.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build())
                .build()

        edamamService = retrofit.create(EdamamService::class.java)
    }

    fun searchRecipe(q: String, from: Int, to: Int): Observable<RecipeResponse> {
        return edamamService.searchRecipe(q = q, from = from, to = to)
    }

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Log.d("OkHttpLog", message)
        })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
        return httpLoggingInterceptor
    }

}