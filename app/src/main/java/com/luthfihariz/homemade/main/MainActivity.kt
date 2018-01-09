package com.luthfihariz.homemade.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.lapism.searchview.SearchView
import com.lapism.searchview.SearchView.OnQueryTextListener
import com.luthfihariz.homemade.R
import com.luthfihariz.homemade.data.Hit
import com.luthfihariz.homemade.data.Recipe
import com.luthfihariz.homemade.data.RecipeRepository
import com.luthfihariz.homemade.main.adapter.RecipeAdapter
import com.luthfihariz.homemade.main.adapter.SpacingItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import net.hockeyapp.android.CrashManager
import net.hockeyapp.android.UpdateManager

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var loadingSnackbar: Snackbar
    private lateinit var presenter: MainPresenter

    override var isActive: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        presenter = MainPresenter(RecipeRepository(), this)
        presenter.searchTodayRandomRecipe()

        svRecipeSearch.versionMargins = SearchView.VersionMargins.TOOLBAR_SMALL

        UpdateManager.register(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        UpdateManager.unregister()
    }

    private fun setupRecyclerView() {
        rvRecipe.layoutManager = LinearLayoutManager(this)
        rvRecipe.addItemDecoration(SpacingItemDecoration(
                resources.getDimensionPixelSize(R.dimen.spacing_xx_small),
                resources.getDimensionPixelSize(R.dimen.spacing_normal)))
    }

    override fun showLoadingIndicator() {
        loadingSnackbar = Snackbar
                .make(rvRecipe.rootView, "Loading", Snackbar.LENGTH_INDEFINITE)
        loadingSnackbar.show()
    }

    override fun hideLoadingIndicator() {
        loadingSnackbar.dismiss()
    }

    override fun showRecipes(hits: List<Hit>) {
        rvRecipe.adapter = RecipeAdapter(hits)
    }

    override fun showFullPageError() {

    }

    override fun showSnackbarError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        super.onResume()
        CrashManager.register(this)
        isActive = true
    }

    override fun onPause() {
        super.onPause()
        isActive = false
    }

}
