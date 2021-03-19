package com.example.recipefinder.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Path;

public interface RecipesApi {
    @GET("api/v2/pokemon/{name}")
    Call<RecipeResponse> getRecipe(@Path("name") String name);
}
