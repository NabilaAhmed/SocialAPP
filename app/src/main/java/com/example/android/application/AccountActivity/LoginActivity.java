package com.example.android.application.AccountActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.application.MainActivity;
import com.example.android.application.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
Button button;
    EditText editText,editText1;
    TextView textView;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        textView= (TextView) findViewById(R.id.text);
        button= (Button) findViewById(R.id.login);
        editText= (EditText) findViewById(R.id.email);
        editText1= (EditText) findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();


        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = editText.getText().toString().trim();
                final String Password = editText1.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Please Enter Ur email", Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    if (TextUtils.isEmpty(Password)) {
                        Toast.makeText(getApplication(), "Please Enter Ur Password", Toast.LENGTH_SHORT).show();
                        return;

                    }
                }
                auth.signInWithEmailAndPassword(email, Password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
//                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (Password.length() < 6) {
                                        editText1.setError("more than 6");
                                    } else {
                                        Toast.makeText(LoginActivity.this,"Failed", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this,"success", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, Home.class);
                                    intent.putExtra("EXTRA_SESSION_ID", email);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });



            }
        });
    }
    public void onClick(View v) {
        Toast.makeText(this,"jnjb",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
    }

}
