package com.luthfihariz.homemade.main

import com.luthfihariz.homemade.data.RecipeRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * Created by luthfihariz on 12/11/17.
 */
class MainPresenter(private val repository: RecipeRepository,
                             private val view: MainContract.View) : MainContract.Presenter {

    private var currentPage = 0
    private var from: Int = 0
    private var to: Int = 20
    private val randomQuery = listOf("chicken", "beef", "spinach", "macaroni", "rice")

    override fun searchRecipe(q: String) {
        view.showLoadingIndicator()
        repository.searchRecipe(q, from, to)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ recipes ->
                    with(view) {
                        if (isActive) {
                            hideLoadingIndicator()
                            showRecipes(recipes.hits)
                        }
                    }
                    increasePage()
                }, {
                    with(view) {
                        if (isActive) {
                            showErrorHandling()
                        }
                    }
                })
    }

    private fun showErrorHandling() {
        when (currentPage) {
            0 -> view.showFullPageError()
            else -> {
                view.showSnackbarError()
            }
        }
    }

    private fun increasePage() {
        currentPage++
        calculatePageRange()
    }

    private fun calculatePageRange() {
        from = (currentPage * 20) + 1
        to = (currentPage * 20) + 20
    }

    override fun searchTodayRandomRecipe() {
        val todayDate = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val todayQuery = randomQuery[todayDate % 5]
        searchRecipe(todayQuery)
    }
}