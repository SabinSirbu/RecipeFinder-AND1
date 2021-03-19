package com.example.recipefinder.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recipefinder.R;
import com.example.recipefinder.View.RecipePageActivity;

public class Login extends AppCompatActivity {

    Button loginButton;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = findViewById(R.id.usernameValue);
        password = findViewById(R.id.passwordValue);

        final Context context = getApplicationContext();
        final String successText = "WELCOME " + username.getText() + "!";
        final String failText = "Username or password is incorrect!";
        final int duration = Toast.LENGTH_SHORT;

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey(RecipePageActivity.RECIPE_NAME_DISCARDED)) {
            String recipeDiscarded = bundle.getString(RecipePageActivity.RECIPE_NAME_DISCARDED);
            username.setText(recipeDiscarded);
        }


        loginButton = findViewById(R.id.login_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((username.getText().toString().matches("user@email.com")) && (password.getText().toString().matches("ILOVEAND"))) {
                    Toast.makeText(context, successText, duration).show();
                }
                else{
                    Toast.makeText(context, failText, duration).show();
                }
            }
        });
    }
}