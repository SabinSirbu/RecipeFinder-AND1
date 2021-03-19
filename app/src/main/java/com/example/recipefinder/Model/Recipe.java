package com.example.recipefinder.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipe_table")
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    private int recipeID;
    private String recipeName;
    private int portions;
    private int prep_time;
    private String recipe_text;
    private String recipePhoto;

    public Recipe(int id,String name, int portions, int time, String text, String photo){
        recipeID = id;
        recipeName = name;
        this.portions = portions;
        prep_time = time;
        recipe_text = text;
        recipePhoto = photo;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public String getRecipeName(){
        return recipeName;
    }

    public int getPortions() {
        return portions;
    }

    public int getPrep_time() {
        return prep_time;
    }

    public String getRecipe_text() {
        return recipe_text;
    }

    public String getRecipePhoto(){
        return recipePhoto;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public void setPrep_time(int prep_time) {
        this.prep_time = prep_time;
    }

    public void setRecipe_text(String recipe_text) {
        this.recipe_text = recipe_text;
    }

    public void setRecipePhoto(String recipePhoto) {
        this.recipePhoto = recipePhoto;
    }
}
