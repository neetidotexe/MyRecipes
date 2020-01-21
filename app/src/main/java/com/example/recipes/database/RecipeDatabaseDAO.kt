package com.example.recipes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDatabaseDAO {

    @Insert
    fun addRecipe(recipe: Recipes)

    @Query("SELECT * from Recipes WHERE recipeId= :key")
    fun getRecipe(key: Long): Recipes?

    @Query("SELECT * FROM Recipes ORDER BY recipeId DESC")
    fun getAllRecipes(): LiveData<List<Recipes>>
}