package com.example.recipes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Recipes::class],
    version = 1
)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun getRecipeDatabaseDao(): RecipeDatabaseDAO

    companion object {

        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun buildDatabase(context: Context): RecipeDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipeDatabase"
                )
                    .build()
            }

            return INSTANCE as RecipeDatabase
        }
    }

}
