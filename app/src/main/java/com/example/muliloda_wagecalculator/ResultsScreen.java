package com.example.muliloda_wagecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;



public class ResultsScreen extends AppCompatActivity implements View.OnClickListener {


    TextView totalWageValue, totalOvertimeValue, totalRegularValue, hoursRenderedValue, hoursOvertimeValue;
    RadioGroup radioGroup;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        totalWageValue = findViewById(R.id.totalWage);
        totalOvertimeValue = findViewById(R.id.totalOvertime);
        totalRegularValue = findViewById(R.id.totalRegular);
        hoursRenderedValue = findViewById(R.id.hoursRendered);
        hoursOvertimeValue = findViewById(R.id.hoursOvertime);
        radioGroup = findViewById(R.id.radioGroup);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("employeeName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));

        hoursRenderedValue.setText(String.valueOf(EmployeeHours));
        calcWage(EmployeeType, EmployeeHours, totalWageValue, totalRegularValue, totalOvertimeValue);



    }

    @SuppressLint("SetTextI18n")
    public void calcWage(String employeeType, Double employeeHours, TextView totalWageValue, TextView totalOvertimeValue, TextView totalRegularValue) {
        double wage = 0.0;
        double otWage = 0.0;

        switch (employeeType) {
            case "regular":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    wage = (employeeHours * 115) + 800;
                    otWage = employeeHours * 115;

                    totalWageValue.setText("P" + wage);
                    totalRegularValue.setText("800");
                    totalOvertimeValue.setText("P" + otWage);
                } else {
                    wage = employeeHours * 100;
                    totalWageValue.setText("P" + wage);
                    totalRegularValue.setText("P" + wage);
                }
                break;
            case "probationary":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    wage = (employeeHours * 100) + 720;
                    otWage = employeeHours * 100;

                    totalWageValue.setText("P" + wage);
                    totalRegularValue.setText("P720");
                    totalOvertimeValue.setText("P" + otWage);
                } else {
                    wage = employeeHours * 90;
                    totalWageValue.setText("P" + wage);
                    totalRegularValue.setText("P" + wage);
                }
                break;
            case "part-time":
                if (employeeHours > 8) {
                    employeeHours = employeeHours - 8;
                    wage = (employeeHours * 90) + 600;
                    otWage = employeeHours * 90;

                    totalWageValue.setText("P" + wage);
                    totalRegularValue.setText("P600");
                    totalOvertimeValue.setText("P" + otWage);
                } else {
                    wage = employeeHours * 75;
                    totalWageValue.setText("P" + wage);
                    totalRegularValue.setText("P" + wage);
                }
                break;
        }

    }
        public void onClick(@NonNull View v) {
            if (v.getId() == R.id.btnBack) {
                startActivity(new Intent(ResultsScreen.this, MainActivity.class));
    }
}}