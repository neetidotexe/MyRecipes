package com.example.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecipeListFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val context = inflater.context

        val root = inflater.inflate(R.layout.fragment_recipe_list, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView?.adapter = DishesAdapter(context)//adapter

        return root
    }

}
