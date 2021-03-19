package com.example.recipefinder.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipefinder.R;

public class RecipePageActivity extends AppCompatActivity {

    TextView titleText;
    EditText prepTimeField;
    Button uploadButton;
    Button discardButton;
    static final String RECIPE_NAME_DISCARDED = "com.example.recipefinder.RECIPE_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_page);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Context context = getApplicationContext();
        final String text = "Discarding recipe and go to login...";
        final int duration = Toast.LENGTH_SHORT;


        titleText = findViewById(R.id.title);
        titleText.setText("RecipePageActivity");

        prepTimeField = findViewById(R.id.cameraType);

        uploadButton = findViewById(R.id.upload);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //titleText.setText(titleText.getText() + " (uploaded)");
                titleText.setText(prepTimeField.getText() + " to prep");
            }
        });
        discardButton = findViewById(R.id.discard);
        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, text, duration).show();
                Intent intent = new Intent(RecipePageActivity.this, Login.class);
                intent.putExtra(RECIPE_NAME_DISCARDED, titleText.getText().toString());
                startActivity(intent);
            }
        });
    }
}