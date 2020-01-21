package com.example.recipes.NavigationComp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.recipes.R
import com.example.recipes.RecyclerView.AddedRecipesAdapter
import com.example.recipes.viewModel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipe_list.*


class ShowAddedRecipesFragment : Fragment() {

    private lateinit var model: RecipeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val context = inflater.context
        val root =  inflater.inflate(R.layout.fragment_show_added_recipes, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView_showAddedRecipe)
        model = ViewModelProviders.of(this).get(RecipeViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)


        // Observe the model
        model.getAllRecipes.observe(this, Observer{recipe->
            // Data bind the recycler view
            recyclerView.adapter = AddedRecipesAdapter(recipe)
        })

        return root
    }


  }
