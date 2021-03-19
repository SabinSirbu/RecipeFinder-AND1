package com.example.recipefinder.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefinder.Model.Recipe;
import com.example.recipefinder.R;

import java.util.ArrayList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    private ArrayList<Recipe> mRecipes;
    final private OnListItemClickListener mOnListItemClickListener;


    RecipesAdapter(ArrayList<Recipe> recipes, OnListItemClickListener listener){
        mRecipes = recipes;
        mOnListItemClickListener = listener;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.recipeName.setText(mRecipes.get(position).getRecipeName());
        //viewHolder.recipePhoto.setImageResource(mRecipes.get(position).getRecipePhotoId());
    }

    public int getItemCount() {
        return mRecipes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView recipeName;
        ImageView recipePhoto;

        ViewHolder(View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipe_name);
            recipePhoto = itemView.findViewById(R.id.recipe_photo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //get the position of the view that was clicked
            mOnListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }
}
