package com.example.android.application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.android.application.AccountActivity.Home;
import com.example.android.application.AccountActivity.LoginActivity;
import com.example.android.application.AccountActivity.SignUpActivity;

public class MainActivity extends AppCompatActivity {


    private static final String MY_PREFS_NAME = "save";
    ImageButton login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main");
        login = (ImageButton) findViewById(R.id.login);
        signup = (ImageButton) findViewById(R.id.signUp);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
        Log.d("outside" + "", "onCreate: ");

        String b = prefs.getString("name", null);

        if (b != null) {
            Toast.makeText(MainActivity.this, "0" + b, Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(MainActivity.this, Home.class);

            intent.putExtra("counter", "1");

            startActivity(intent);

            Log.d("", b + "\n");

        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
//
//            String dt = "";
//            prefs.edit().putString("name",dt).commit();


                startActivity(new Intent(MainActivity.this, SignUpActivity.class));

            }
        });
    }

}
