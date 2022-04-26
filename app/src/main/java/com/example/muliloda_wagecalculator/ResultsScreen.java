package com.example.muliloda_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ResultsScreen extends AppCompatActivity {

    int hours, othours, wage, otwage, totalwage;
    TextView totalWageValue, totalOvertimeValue, totalRegularValue, hoursRenderedValue, hoursOvertimeValue;
    RadioGroup radioGroup;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);
        Intent i = getIntent();
        Intent intent;

        totalWageValue = findViewById(R.id.totalWage);
        totalOvertimeValue = findViewById(R.id.totalOvertime);
        totalRegularValue = findViewById(R.id.totalRegular);
        hoursRenderedValue = findViewById(R.id.hoursRendered);
        hoursOvertimeValue = findViewById(R.id.hoursOvertime);
        radioGroup = findViewById(R.id.radioGroup);
        btnBack = findViewById(R.id.btnBack);

        totalWageValue.setText(String.valueOf(totalwage));
        totalOvertimeValue.setText(String.valueOf(othours));
        totalRegularValue.setText(String.valueOf(wage));
        hoursRenderedValue.setText(String.valueOf(hours));
        totalOvertimeValue.setText(String.valueOf(othours));
        radioGroup = findViewById(R.id.radioGroup);

        btnBack.setOnClickListener(v -> startActivity(new Intent(Display.this,MainActivity.class)));


        hoursRenderedValue = intent.getIntExtra("hours", 0);
        radioGroup = intent.getStringExtra("type");

        switch (radioGroup) {
            case "Regular":
            default:
                if (hours > 8) {
                    othours = hours - 8;
                    otwage = othours * 115;

                }
                wage = (hours - othours) * 100;
                totalwage = wage + otwage;
                break;
            case "Probationary":
                if (hours > 8) {
                    othours = hours - 8;
                    otwage = othours * 100;

                }
                wage = (hours - othours) * 90;
                totalwage = wage + otwage;
                break;
            case "Part-Time":
                    if (hours > 8) {
                        othours = hours - 8;
                                otwage = othours * 90;
                    }
                    wage = (hours - othours) * 75;
                    totalwage = wage + otwage;
                    break;
                }
        }



}