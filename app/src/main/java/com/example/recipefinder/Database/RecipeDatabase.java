package com.example.recipefinder.Database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class RecipeDatabase extends RoomDatabase {

    private static RecipeDatabase instance;
    public abstract RecipeDao recipeDao();

    public static synchronized RecipeDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RecipeDatabase.class, "recipe_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
