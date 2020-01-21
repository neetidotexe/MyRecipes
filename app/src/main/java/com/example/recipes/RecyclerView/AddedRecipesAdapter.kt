package com.example.recipes.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R
import com.example.recipes.database.Recipes

class AddedRecipesAdapter(val addedrecipes: List<Recipes>) : RecyclerView.Adapter<AddedRecipesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.added_recipe_item_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return addedrecipes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textAddedRecipeName.text=addedrecipes[position].recipeName
        holder.textAddedRecipeDesc.text=addedrecipes[position].recipeDescription
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textAddedRecipeName = itemView.findViewById<TextView>(R.id.text_addedRecipeName)
        val textAddedRecipeDesc = itemView.findViewById<TextView>(R.id.text_addedRecipeDescription)
    }
}
