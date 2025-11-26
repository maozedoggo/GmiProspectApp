package com.example.gmiprospectapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class EnquiryActivity extends AppCompatActivity {
    EditText etName, etEmail, etMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String subject = "GMI Prospect Enquiry from " + etName.getText().toString();
            String body = "Email: " + etEmail.getText().toString() + "\n\nMessage:\n" + etMessage.getText().toString();
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:")); // only email apps
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"admissions@gmi.edu.my"}); // placeholder
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(Intent.EXTRA_TEXT, body);
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            } else {
                Toast.makeText(EnquiryActivity.this, "No email app found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
