package com.luthfihariz.homemade.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by luthfihariz on 12/11/17.
 */
interface EdamamService {

    @GET("/search")
    fun searchRecipe(@Query("q") q : String ,
                     @Query("r") r: String? = null,
                     @Query("from") from: Int,
                     @Query("to") to: Int): Observable<RecipeResponse>
}