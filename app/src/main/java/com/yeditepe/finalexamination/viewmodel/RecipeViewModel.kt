package com.yeditepe.finalexamination.viewmodel

import android.R
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yeditepe.finalexamination.model.Recipe

class RecipeViewModel : ViewModel() {
    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> get() = _recipes

    private val _selectedRecipe = MutableLiveData<Recipe?>()
    val selectedRecipe: LiveData<Recipe?> get() = _selectedRecipe

    init {
        // TODO: Initialize _recipes with a list of sample data
        _recipes.value = listOf(
            Recipe(id = 1, title = "Lasagna", description = "Delicious lasagna recipe", imageResId = 0),
            Recipe(id = 2, title = "Biscuit", description = "Fresh green biscuit", imageResId = R.drawable.ic_menu_save)
        )
    }

    fun selectRecipe(recipe: Recipe) {
        // TODO: Update _selectedRecipe with the selected
        _selectedRecipe.value = recipe
    }

    fun getRecipeById(id:Int): Recipe?{
        // TODO: Complete the method such that it will return selected Recipe if exist otherwise null
        val found = _recipes.value?.firstOrNull() { it.id == id }
        _selectedRecipe.value = found
        return found
    }
}
