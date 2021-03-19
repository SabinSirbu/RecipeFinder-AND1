package com.example.recipefinder.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.recipefinder.Model.Recipe;
import com.example.recipefinder.Repository.RecipeRepository;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {

    private RecipeRepository repository;

    public RecipeViewModel(Application app){
        super(app);
        repository = RecipeRepository.getInstance(app);
    }

    public LiveData<List<Recipe>> getAllRecipes(){
        return repository.getAllRecipes();
    }

    public void insert(Recipe recipe){
        repository.insert(recipe);
    }

    void update(Recipe recipe){
        repository.update(recipe);
    }

    public void deleteAllRecipes(){
        repository.deleteAllRecipes();
    }

}
