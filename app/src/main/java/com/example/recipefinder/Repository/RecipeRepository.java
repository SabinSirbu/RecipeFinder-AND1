package com.example.recipefinder.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.recipefinder.API.RecipeResponse;
import com.example.recipefinder.API.RecipesApi;
import com.example.recipefinder.API.ServiceGenerator;
import com.example.recipefinder.Database.RecipeDao;
import com.example.recipefinder.Database.RecipeDatabase;
import com.example.recipefinder.Model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeRepository {

    private RecipeDao recipeDao;
    private static RecipeRepository instance;
    private LiveData<List<Recipe>> allRecipes;

    private RecipeRepository(Application application){
        RecipeDatabase database = RecipeDatabase.getInstance(application);
        recipeDao = database.recipeDao();
        allRecipes = recipeDao.getAllRecipes();
    }

    public static RecipeRepository getInstance(Application application){
        if(instance == null){
            instance = new RecipeRepository(application);
        }
        return instance;
    }

    public LiveData<List<Recipe>> getAllRecipes(){
        return allRecipes;
    }

    public void insert(Recipe recipe){
        new InsertRecipeAsync(recipeDao).execute(recipe);
    }

    public void update(Recipe recipe){
        recipeDao.update(recipe);
    }

    public void deleteAllRecipes(){
        recipeDao.deleteAllRecipes();
    }

    private static class InsertRecipeAsync extends AsyncTask<Recipe, Void, Void>{
        private RecipeDao recipeDao;

        private InsertRecipeAsync(RecipeDao recipeDao){
            this.recipeDao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDao.insert(recipes[0]);
            return null;
        }
    }

    public void requestRecipe(String recipeName){
        RecipesApi recipesApi = ServiceGenerator.getRecipesApi();
        Call<RecipeResponse> call = recipesApi.getRecipe(recipeName);
        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if(response.code() == 200){
                    //recipe.set
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });
    }
}
