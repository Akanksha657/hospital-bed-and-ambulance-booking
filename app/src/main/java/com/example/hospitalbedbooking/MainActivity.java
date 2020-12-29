package com.example.hospitalbedbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText e1,e2;
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.register_user);
        b2 = findViewById(R.id.register);
        b3 = findViewById(R.id.hospital);
        b4 = findViewById(R.id.Forget_password);
        e1 = findViewById(R.id.email);
        e2 = findViewById(R.id.Password);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_user:
                String email = e1.getText().toString().trim();
                String password = e2.getText().toString().trim();
                login(email,password);
                break;

            case R.id.register:
                Intent it = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(it);
                break;

            case R.id.hospital:
                it = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(it);
                break;

            case R.id.Forget_password:
                it = new Intent(MainActivity.this, MainActivity.class);
                startActivity(it);
                break;
        }
    }

    void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent it = new Intent(MainActivity.this, MainActivity5.class);
                            startActivity(it);

                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            Toast.makeText(MainActivity.this, "invalid user or password", Toast.LENGTH_SHORT).show();

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

}