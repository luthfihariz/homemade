package com.luthfihariz.homemade.data

/**
 * Created by luthfihariz on 12/5/17.
 */

data class RecipeResponse(
        val q: String,
        val from: Int,
        val to: Int,
        val params: Params,
        val more: Boolean,
        val count: Int,
        val hits: List<Hit>
)

data class Params(
        val sane: List<Any>,
        val q: List<String>,
        val app_key: List<String>,
        val health: List<String>,
        val from: List<String>,
        val to: List<String>,
        val calories: List<String>,
        val app_id: List<String>
)

data class Hit(
        val recipe: Recipe,
        val bookmarked: Boolean,
        val bought: Boolean
)

data class Recipe(
        val uri: String,
        val label: String,
        val image: String,
        val source: String,
        val url: String,
        val shareAs: String,
        val yield: Double,
        val dietLabels: List<String>,
        val healthLabels: List<String>,
        val tags: List<String>,
        val ingredients: List<Ingredient?>,
        val calories: Double
)

data class NutrientValue(
        val label: String,
        val quantity: Double,
        val unit: String
)

data class Ingredient(
        val text: String,
        val weight: Double
)

data class Digest(
        val label: String,
        val tag: String,
        val schemaOrgTag: String,
        val total: Double,
        val hasRDI: Boolean,
        val daily: Double,
        val unit: String,
        val sub: List<Sub>
)

data class Sub(
        val label: String,
        val tag: String,
        val schemaOrgTag: String,
        val total: Double,
        val hasRDI: Boolean,
        val daily: Double,
        val unit: String
)