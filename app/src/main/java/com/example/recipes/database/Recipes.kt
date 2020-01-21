package com.example.recipes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Recipes  (
    val recipeName:String,
    val recipeDescription:String
)
{
    @PrimaryKey(autoGenerate = true)
    var recipeId: Int=0
}