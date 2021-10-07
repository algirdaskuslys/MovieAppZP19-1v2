package com.example.movie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View focusView) {

                boolean cancel = false;
                focusView = null;

                if (!Validation.isUsernameValid(username.getText().toString())) {
                    username.setError(getString(R.string.login_invalid_username));
                    cancel = true;
                }

                if (!Validation.isPasswordValid(password.getText().toString())) {
                    password.setError(getString(R.string.login_invalid_password));
                    cancel = true;
                }

                if (cancel) { // turime klaidų
//                    focusView.requestFocus();
                } else { // praėjome autentifikacija

                    Toast.makeText(LoginActivity.this, username.getText().toString() + "\n" + password.getText().toString(),

                            Toast.LENGTH_LONG).show();

                    //perform action on click
                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                    startActivity(goToSearchActivity);

                }//else


            }//onClick
        });


    }
}
