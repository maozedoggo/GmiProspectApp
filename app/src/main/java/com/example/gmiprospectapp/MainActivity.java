package com.example.gmiprospectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnCourses, btnEligibility, btnEnquiry, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCourses = findViewById(R.id.btnCourses);
        btnEligibility = findViewById(R.id.btnEligibility);
        btnEnquiry = findViewById(R.id.btnEnquiry);
        btnAbout = findViewById(R.id.btnAbout);

        btnCourses.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, com.example.gmiprospectapp.CoursesActivity.class)));

        btnEligibility.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, com.example.gmiprospectapp.EligibilityActivity.class)));

        btnEnquiry.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, com.example.gmiprospectapp.EnquiryActivity.class)));

        btnAbout.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AboutActivity.class)));
    }
}
