package com.example.hospitalbedbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    EditText e1, e2, e3, e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = findViewById(R.id.register_user);
        e1 = findViewById(R.id.name);
        e2 = findViewById(R.id.ru_email);
        e3 = findViewById(R.id.contact);
        e4 = findViewById(R.id.ru_password);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = e1.getText().toString().trim();
        String email = e2.getText().toString().trim();
        String contact = e3.getText().toString().trim();
        String password = e2.getText().toString().trim();
        register(name, email, contact, password);
    }


    void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent it = new Intent(MainActivity2.this, MainActivity5.class);
                            startActivity(it);

                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            Toast.makeText(MainActivity2.this, "invalid user or password", Toast.LENGTH_SHORT).show();

                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });

    }


    void register(String name, String email, String contact, String password) {
        mAuth.createUserWithEmailAndPassword(name, email, contact, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity2.this, "Success", Toast.LENGTH_SHORT).show();
                            login(email,password);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity2.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });


    }
}