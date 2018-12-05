package com.example.android.application.AccountActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.application.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "save";
    Button button;
    private FirebaseAuth auth;
    EditText email, Password, Confirmpassword;
    private String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("signUp");
        auth = FirebaseAuth.getInstance();
        button = (Button) findViewById(R.id.register);
        email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        Confirmpassword = (EditText) findViewById(R.id.confirmPassword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String emaill = email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                if (TextUtils.isEmpty(emaill)) {
                    Toast.makeText(getApplication(), "Please Enter Ur email", Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(getApplication(), "Please Enter Ur Password", Toast.LENGTH_SHORT).show();
                        return;

                    } else {
                        if (password.length() <= 6) {
                            Toast.makeText(getApplication(), "password should more than 6 chars", Toast.LENGTH_SHORT).show();
                            return;
                        } else {

                        }
                    }
                }
                auth.createUserWithEmailAndPassword(emaill, password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                saveID();
//                                Toast.makeText(SignUpActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
//                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
//                                    Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException(),
                                    Toast.makeText(SignUpActivity.this, "ConnectiobFailed" , Toast.LENGTH_SHORT).show();
                                } else {
//                                    Toast.makeText(SignUpActivity.this, "Authentication sucess." + task.getException(), Toast.LENGTH_SHORT).show();
                                    Toast.makeText(SignUpActivity.this, "Acount Added", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(SignUpActivity.this, Home.class);
                                    intent.putExtra("EXTRA_SESSION_ID", emaill);
                                    Toast.makeText(SignUpActivity.this, emaill+"+++++++++", Toast.LENGTH_SHORT).show();

                                    startActivity(intent);
//                                    startActivity(new Intent(SignUpActivity.this,Home.class));
                                    finish();
                                }
                            }
                        });

            }
        });

    }

    private void saveID() {
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, 0).edit();
        editor.putString("name", " ");
        Log.d(TAG, "sharedsave: ");
        editor.apply();
        editor.commit();

    }
}
