package com.luthfihariz.homemade.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.luthfihariz.homemade.R
import com.luthfihariz.homemade.data.Hit
import com.luthfihariz.homemade.util.inflate
import kotlinx.android.synthetic.main.item_recipe.view.*

/**
 * Created by luthfihariz on 12/5/17.
 */
class RecipeAdapter(private var hits: List<Hit>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onBindViewHolder(holder: RecipeViewHolder?, position: Int) {
        val hit = hits[position]
        holder?.bind(hit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder
            = RecipeViewHolder(parent.inflate(R.layout.item_recipe))


    override fun getItemCount(): Int = hits.size

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hit: Hit) {
            itemView.tvRecipeName.text = hit.recipe.label
            itemView.tvCalories.text = String.format("%.0f calories", hit.recipe.calories)
            itemView.tvTotalServings.text = String.format("%.0f servings", hit.recipe.yield)
            itemView.tvIngredients.text = String.format("%d ingredients", hit.recipe.ingredients.size)
            Glide.with(itemView).load(hit.recipe.image).into(itemView.ivRecipe)
        }
    }
}

