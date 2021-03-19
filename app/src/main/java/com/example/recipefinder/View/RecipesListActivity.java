package com.example.recipefinder.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recipefinder.Model.Recipe;
import com.example.recipefinder.R;
import com.example.recipefinder.ViewModel.RecipeViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecipesListActivity extends AppCompatActivity implements RecipesAdapter.OnListItemClickListener{

    private RecipeViewModel recipeViewModel;

    RecyclerView mRecipesList;
    RecipesAdapter mRecipesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_list);

        mRecipesList = findViewById(R.id.recipes_list);
        mRecipesList.hasFixedSize();
        mRecipesList.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<Recipe> recipeList = new ArrayList<>();


        mRecipesAdapter = new RecipesAdapter(recipeList, this);
        mRecipesList.setAdapter(mRecipesAdapter);

        recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        recipeViewModel.getAllRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                recipeList.clear();
                recipeList.addAll(recipes);
                mRecipesAdapter = new RecipesAdapter(recipeList, RecipesListActivity.this);
                mRecipesList.setAdapter(mRecipesAdapter);
            }
        });
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        int recipesCount = clickedItemIndex + 1;
        Toast.makeText(this, "Recipe number: #" + recipesCount, Toast.LENGTH_SHORT).show();
    }
}