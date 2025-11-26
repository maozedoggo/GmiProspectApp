package com.example.gmiprospectapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CoursesActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        listView = findViewById(R.id.listCourses);

        ArrayList<String> courses = new ArrayList<>();

        // === Diploma Programmes ===
        courses.add("⚙️ Mechanical Engineering");
        courses.add("   • Diploma in Mechatronic Engineering");
        courses.add("   • Diploma in Mechanical Engineering (Automotive/Aerospace)");
        courses.add("   • Diploma in Mechanical Engineering (Manufacturing)");
        courses.add("   • Diploma in Heating, Ventilation, and Air Conditioning (HVAC)");
        courses.add("   • Diploma in Piping Engineering Design");
        courses.add("   • Diploma in Engineering Design and Simulation");
        courses.add(""); // Spacer

        courses.add("⚡ Electrical Engineering");
        courses.add("   • Diploma in Electronic Engineering (Focused on circuits/devices)");
        courses.add("   • Diploma in Electrical Power Engineering (Focused on generation/systems)");
        courses.add("   • Diploma in Instrumentation and Control Engineering");
        courses.add("   • Diploma in Autotronics (Automotive Electronics)");
        courses.add("   • Diploma in Renewable Energy Technology");
        courses.add("   • Diploma in Electronic and Communications Engineering");
        courses.add(""); // Spacer

        courses.add("💻 Computer and Information");
        courses.add("   • Diploma in Computer Science");
        courses.add("   • Diploma in Software Engineering");
        courses.add("   • Diploma in Computer Networking/Cyber Security");
        courses.add("   • Diploma in Information Communication Technology (ICT)");
        courses.add("   • Diploma in Data and Artificial Intelligence (AI)");
        courses.add("   • Diploma in Multimedia/Digital Technology");
        courses.add(""); // Spacer

        // === Pre-University Programmes ===
        courses.add("GAPP (German A-Level Preparatory Programme)");
        courses.add(""); // Spacer
        courses.add("GUFP (GMI-UTP Foundation Programme)");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        listView.setAdapter(adapter);
    }
}
