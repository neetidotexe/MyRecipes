package com.example.recipes.NavigationComp

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.recipes.R
import com.example.recipes.viewModel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_delete_recipe.*


class DeleteRecipeFragment : Fragment() {

    private lateinit var model: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val context = inflater.context
        val root = inflater.inflate(R.layout.fragment_delete_recipe, container, false)

        model = ViewModelProviders.of(this).get(RecipeViewModel::class.java)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_deleteRecipe.setOnClickListener {
            val rname: String = text_enterRecipeName.text.toString()
            if(rname.isEmpty()){
                Toast.makeText(activity,"Recipe name can't be empty", Toast.LENGTH_LONG).show()
            }
            else{
                deleteRecipe(rname)
            }
            text_enterRecipeName.setText("")
        }
    }

    private fun deleteRecipe(recipeName: String) {

        class DeleteRecipe : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg p0: Void?): Void? {
                model.deleteRecipe(recipeName)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(activity,"Recipe Deleted", Toast.LENGTH_LONG).show()
            }
        }
        DeleteRecipe().execute()
    }


}
