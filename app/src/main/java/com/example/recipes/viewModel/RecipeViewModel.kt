package com.example.recipes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recipes.database.RecipeDatabase
import com.example.recipes.database.Recipes

class RecipeViewModel(application:Application):AndroidViewModel(application) {
    private val db:RecipeDatabase = RecipeDatabase.buildDatabase(application)

    internal val getAllRecipes : LiveData<List<Recipes>> = db.getRecipeDatabaseDao().getAllRecipes()

    fun insert(recipes: Recipes){
        db.getRecipeDatabaseDao().addRecipe(recipes)
    }

    fun deleteRecipe(rname: String){
        db.getRecipeDatabaseDao().deleteRecipe(rname)


    }
}