package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Module extends AppCompatActivity {
    Button admin,tpo,student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        getSupportActionBar().setTitle("Select Your Post");

        admin=findViewById(R.id.admin);
        tpo=findViewById(R.id.tpo);
        student=findViewById(R.id.student);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Module.this,Admin_Login.class);
                startActivity(intent);
            }
        });

        tpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Module.this,Tpo_Login.class);
                startActivity(intent);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Module.this,Student_Login.class);
                startActivity(intent);
            }
        });
    }
}
