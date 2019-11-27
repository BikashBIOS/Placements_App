package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TpoPage extends AppCompatActivity {

    Button company;
    Button papers;
    Button students;
    TextView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_page);
        getSupportActionBar().setTitle("TPO Fires");

        company=findViewById(R.id.addcompany);
        papers=findViewById(R.id.addpapers);
        students=findViewById(R.id.addstudents);
        home=findViewById(R.id.homedir);
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TpoPage.this,Image_Upload.class));
            }
        });

        papers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TpoPage.this, PdfUpload.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TpoPage.this,Home_Page.class));
            }
        });

    }
    public void direct(){

    }
}
