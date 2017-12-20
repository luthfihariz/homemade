package com.luthfihariz.homemade.main

import com.luthfihariz.homemade.data.Hit

/**
 * Created by luthfihariz on 12/11/17.
 */
interface MainContract {
    interface View {

        var isActive: Boolean

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showRecipes(hits: List<Hit>)

        fun showFullPageError()

        fun showSnackbarError()

    }

    interface Presenter {
        fun searchRecipe(q: String)

        fun searchTodayRandomRecipe()
    }
}