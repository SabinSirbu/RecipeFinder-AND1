package com.example.recipefinder.API;

import com.example.recipefinder.Model.Recipe;

public class RecipeResponse {
    private int id;
    private String name;
    private int order;
    private int weight;
    private String location_area_encounters;
    private Sprites sprites;


    public Recipe getRecipe(){
        return new Recipe(id,name, order, weight, location_area_encounters, sprites.front_default);
    }

    private class Sprites {
        private String front_default;
    }



}
