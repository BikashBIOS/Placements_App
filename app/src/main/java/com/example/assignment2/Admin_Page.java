package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Page extends AppCompatActivity {
    Button tpo,student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);
        getSupportActionBar().setTitle("Select who you want to Add");

        tpo=findViewById(R.id.tpo);
        student=findViewById(R.id.student);

        tpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Admin_Page.this,Tpo_Register.class);
                startActivity(intent);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Admin_Page.this,Student_Register.class);
                startActivity(intent);
            }
        });
    }
}
