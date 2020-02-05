package com.example.recipes.NavigationComp

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.recipes.R

class RecipeDescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val context=inflater.context
        val root= inflater.inflate(R.layout.fragment_recipe_description, container, false)

        val text_recipeName=root.findViewById<TextView>(R.id.text_rd_recipeName)
        val text_recipeDesc=root.findViewById<TextView>(R.id.text_rd_recipeDescription)

        text_recipeName.text=arguments?.getString("dishname")

        when(text_recipeName.text){
            "FRUIT CUSTARD"->text_recipeDesc.text=getString(R.string.fruit_custard)

            "HALWA"->text_recipeDesc.text=getString(R.string.halwa)

            "BEETROOT SOUP"->text_recipeDesc.text=getString(R.string.beetroot_soup)

            "KADHAI PANEER"->text_recipeDesc.text=getString(R.string.kadhai_paneer)

            "PAV BHAJI"->text_recipeDesc.text=getString(R.string.pav_bhaji)

            "RAJMA RICE"->text_recipeDesc.text=getString(R.string.rajma_rice)
        }

        text_recipeDesc.setMovementMethod(ScrollingMovementMethod())

        return root
    }
}
