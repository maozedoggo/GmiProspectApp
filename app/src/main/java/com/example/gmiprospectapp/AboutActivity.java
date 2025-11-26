package com.example.gmiprospectapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    // Define the URL for the GMI website
    private static final String GMI_WEBSITE_URL = "https://www.gmi.edu.my";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Find the button in the layout by its ID
        Button visitWebsiteButton = findViewById(R.id.btnVisitWebsite);

        // Set a click listener on the button
        visitWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the web browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(GMI_WEBSITE_URL));
                startActivity(browserIntent);
            }
        });
    }
}
