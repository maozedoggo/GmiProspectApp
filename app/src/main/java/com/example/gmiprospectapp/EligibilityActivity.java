package com.example.gmiprospectapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class EligibilityActivity extends AppCompatActivity {

    // UI Components
    CheckBox cbMath, cbAddMath, cbEnglish, cbPhysics, cbChemistry, cbBahasa;
    Button btnCheck, btnApplyOnline;
    TextView tvResult;

    private static final String APPLICATION_URL = "https://gmi.vialing.com/oa/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);

        // Initialize all your UI components from the XML layout
        cbMath = findViewById(R.id.cbMath);
        cbAddMath = findViewById(R.id.cbAddMath);
        cbEnglish = findViewById(R.id.cbEnglish);
        cbPhysics = findViewById(R.id.cbPhysics);
        cbChemistry = findViewById(R.id.cbChemistry);
        cbBahasa = findViewById(R.id.cbBahasa);
        btnCheck = findViewById(R.id.btnCheck);
        tvResult = findViewById(R.id.tvResult);
        btnApplyOnline = findViewById(R.id.btnApplyOnline);

        btnCheck.setOnClickListener(v -> {
            // Get the status of each checkbox.
            boolean hasMathC = cbMath.isChecked();
            boolean hasAddMathC = cbAddMath.isChecked();
            boolean hasEnglishC = cbEnglish.isChecked();
            boolean hasPhysicsC = cbPhysics.isChecked();
            boolean hasChemistryC = cbChemistry.isChecked();
            boolean hasBahasaC = cbBahasa.isChecked();

            // Compute eligible courses based on the checked subjects.
            ArrayList<String> eligible = computeEligibleCourses(hasBahasaC, hasEnglishC, hasMathC, hasAddMathC, hasPhysicsC, hasChemistryC);

            // Display the results to the user.
            if (eligible.isEmpty()) {
                tvResult.setText("Sorry — you are not eligible for any listed courses based on the subjects selected.");
                btnApplyOnline.setVisibility(View.GONE);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("You are eligible for:\n");
                for (String s : eligible) {
                    sb.append("- ").append(s).append("\n");
                }
                tvResult.setText(sb.toString());
                btnApplyOnline.setVisibility(View.VISIBLE);
            }
        });

        btnApplyOnline.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(APPLICATION_URL));
            startActivity(browserIntent);
        });
    }

    /**
     * Computes eligible courses based on new, specific SPM/O-Level requirements.
     * This version uses booleans (true = at least grade C).
     * A real-world app should pass grade strings ('A', 'B', 'C') for more accurate checks.
     * @return An ArrayList of strings containing the names of eligible courses.
     */
    private ArrayList<String> computeEligibleCourses(boolean hasBahasaC, boolean hasEnglishC, boolean hasMathC, boolean hasAddMathC, boolean hasPhysicsC, boolean hasChemistryC) {
        ArrayList<String> list = new ArrayList<>();

        // --- GAPP (German A-Level Preparatory Programme) ---
        // Private Candidates rule: SPM or equivalent C for: English, Mathematics, Additional Mathematics, Physics, Chemistry.
        // The "plus 2 other subjects" part is ambiguous, so we check the core subjects.
        boolean gappCoreSubjectsMet = hasEnglishC && hasMathC && hasAddMathC && hasPhysicsC && hasChemistryC;

        if (gappCoreSubjectsMet) {
            // Since we can't distinguish between 'A' and 'C' grades, we list the general program with a note.
            list.add("GAPP (German A-Level Preparatory Programme)\n  (Note: Sponsored requires 'A's, Private requires 'C's in core subjects)");
        }

        // --- GUFP (GMI-UTP Foundation Programme) ---
        // SPM Rule: Minimum C in Bahasa Melayu, English, Mathematics, Additional Mathematics, Physics, and Chemistry.
        boolean gufpSpmRuleMet = hasBahasaC && hasEnglishC && hasMathC && hasAddMathC && hasPhysicsC && hasChemistryC;

        // O-Level Rule: Minimum C in Mathematics, Physics, Chemistry, Additional Mathematics, and at least one other subject.
        // We assume the "one other subject" rule is met if the core subjects are passed.
        boolean gufpOLevelRuleMet = hasMathC && hasPhysicsC && hasChemistryC && hasAddMathC && hasEnglishC; // English is a common "other" subject.

        if (gufpSpmRuleMet || gufpOLevelRuleMet) {
            // Avoid adding duplicates if already added by another rule.
            if (!list.contains("GUFP (GMI-UTP Foundation Programme)")) {
                list.add("GUFP (GMI-UTP Foundation Programme)");
            }
        }

        return list;
    }
}
