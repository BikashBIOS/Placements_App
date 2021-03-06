package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Student_Register extends AppCompatActivity {
    EditText name,branch,percentage,email,password;
    Button register;
    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__register);
        getSupportActionBar().setTitle("Student Register");

        name=findViewById(R.id.name);
        branch=findViewById(R.id.branch);
        percentage=findViewById(R.id.percent);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        auth=FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_name=name.getText().toString();
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();
                String txt_branch=branch.getText().toString();
                String txt_percent=percentage.getText().toString();

                if (TextUtils.isEmpty(txt_name) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(Student_Register.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else if(txt_password.length()<6){
                    Toast.makeText(Student_Register.this, "Password must be atleast 6 characters", Toast.LENGTH_SHORT).show();
                }
                else {
                    register(txt_name,txt_email,txt_password,txt_branch,txt_percent);
                }
            }
        });
    }
    private void register(final String name, final String email, final String password, final String branch, final String percent) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            assert firebaseUser != null;
                            String userid = firebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("Students").child(userid);

                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("name", name);
                            hashMap.put("email",email);
                            hashMap.put("password",password);
                            hashMap.put("branch",branch);
                            hashMap.put("percentage",percent);



                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Student_Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Student_Register.this, Admin_Page.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });


                        } else {
                            Toast.makeText(Student_Register.this, "You cannot register with this email and password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
