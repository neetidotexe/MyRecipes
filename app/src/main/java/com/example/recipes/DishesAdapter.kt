package com.example.recipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DishesAdapter(var context: Context):RecyclerView.Adapter<DishesAdapter.ViewHolder>(){

    private val dish_name = arrayOf("cake","ice cream","pasta","pizza","noodles","banana pie")

    private val dish_image = intArrayOf(R.drawable.cake,
        R.drawable.icecream,R.drawable.pasta,R.drawable.pizza,R.drawable.noodles,R.drawable.bananapie)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_list,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dish_name.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.textDishName.text = dish_name[i]
        viewHolder.imageDishPic.setImageResource(dish_image[i])
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textDishName=itemView.findViewById<TextView>(R.id.text_dishName) as TextView
        val imageDishPic=itemView.findViewById<ImageView>(R.id.image_dishPic) as ImageView
    }
}