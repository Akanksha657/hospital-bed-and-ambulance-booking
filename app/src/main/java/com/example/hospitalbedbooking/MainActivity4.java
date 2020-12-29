package com.example.hospitalbedbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    EditText e1,e2,e3,e4,e5,e6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b1=findViewById(R.id.register_user);
        e1=findViewById(R.id.name2);
        e2=findViewById(R.id.email);
        e1=findViewById(R.id.name2);
        e1=findViewById(R.id.name2);
        e1=findViewById(R.id.name2);
        e1=findViewById(R.id.name2);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}