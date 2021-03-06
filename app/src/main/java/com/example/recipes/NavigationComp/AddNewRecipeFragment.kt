package com.example.recipes.NavigationComp

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

import com.example.recipes.R
import com.example.recipes.database.Recipes
import com.example.recipes.viewModel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_add_new_recipe.*

class AddNewRecipeFragment : Fragment() {

    private lateinit var model: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        model = ViewModelProviders.of(this).get(RecipeViewModel::class.java)

        return inflater.inflate(R.layout.fragment_add_new_recipe, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Button_submitRecipe.setOnClickListener {
            val recipeName = text_recipeName.text.toString().trim()
            val recipeDescription = text_recipeDesc.text.toString().trim()

            val recipe = Recipes(recipeName, recipeDescription)

            if(recipeName.isEmpty() || recipeDescription.isEmpty()) {
                Toast.makeText(activity,"Recipe Name and Recipe Description both are necessary",Toast.LENGTH_LONG).show()
            }
            else{
                saveRecipe(recipe)
            }

            text_recipeName.requestFocus()
            text_recipeName.setText("")
            text_recipeDesc.setText("")
        }
    }

    private fun saveRecipe(recipe: Recipes) {

        class SaveRecipe : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg p0: Void?): Void? {
                model.insert(recipe)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(activity,"Recipe Saved",Toast.LENGTH_LONG).show()
            }
        }
        SaveRecipe().execute()
    }

}


