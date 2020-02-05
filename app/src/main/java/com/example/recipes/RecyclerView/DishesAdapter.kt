package com.example.recipes.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R

class DishesAdapter(var context: Context, val findNavController: NavController) :
    RecyclerView.Adapter<DishesAdapter.ViewHolder>() {

    private val dish_name = arrayOf("BEETROOT SOUP","KADHAI PANEER","PAV BHAJI","RAJMA RICE","FRUIT CUSTARD","HALWA")

    private val dish_image = intArrayOf(
        R.drawable.soup,
        R.drawable.kadhaipaneer,
        R.drawable.pavbhaji,
        R.drawable.rajmarice,
        R.drawable.fruitcustard,
        R.drawable.halwa
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dish_name.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.buttonDishName.text = dish_name[i]
        viewHolder.imageDishPic.setImageResource(dish_image[i])

        viewHolder.buttonDishName.setOnClickListener {
            var bundle = bundleOf("dishname" to viewHolder.buttonDishName.text )
            findNavController.navigate(R.id.action_recipeListFragment_to_recipeDescriptionFragment,bundle)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val buttonDishName = itemView.findViewById<Button>(R.id.button_dishName)
        val imageDishPic = itemView.findViewById<ImageView>(R.id.image_dishPic)
    }


}

