package com.example.recipes

import android.app.Application
import com.facebook.stetho.Stetho

class RecipeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}