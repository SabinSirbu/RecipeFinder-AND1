package com.example.recipefinder.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.recipefinder.Model.Recipe;
import com.example.recipefinder.R;
import com.example.recipefinder.ViewModel.RecipeViewModel;

import java.util.List;

public class AddRecipeActivity extends AppCompatActivity {

    private RecipeViewModel recipeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);

        recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        recipeViewModel.getAllRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {

            }
        });
    }

    public void saveRecipe(View view){
        //recipeViewModel.insert(new Recipe());
    }

    public void deleteAllRecipes(View view){
        recipeViewModel.deleteAllRecipes();
    }
}