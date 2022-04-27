package com.example.muliloda_wagecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class ResultsScreen extends AppCompatActivity implements View.OnClickListener {


    TextView txtWage, txtOvertimeWage, txtRegularWage, txtHours, txtOvertimeHours;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        txtWage = findViewById(R.id.totalWageValue);
        txtOvertimeWage = findViewById(R.id.totalOvertimeValue);
        txtRegularWage = findViewById(R.id.totalRegularValue);
        txtHours = findViewById(R.id.hoursRenderedValue);
        txtOvertimeHours = findViewById(R.id.hoursOvertimeValue);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));

        txtHours.setText(String.valueOf(EmployeeHours));
        compWage(EmployeeType, EmployeeHours, txtWage, txtRegularWage, txtOvertimeHours);

    }

    @SuppressLint("SetTextI18n")
    public void compWage(String employeeType, Double employeeHours, TextView txtWage, TextView txtOvertimeWage, TextView txtRegularWage) {
        double wage = 0.0;
        double otWage = 0.0;

        switch (employeeType) {
            case "regular":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    wage = (employeeHours * 115) + 800;
                    otWage = employeeHours * 115;

                    txtWage.setText("P" + String.valueOf(wage));
                    txtRegularWage.setText("P800");
                    txtOvertimeWage.setText("P" + String.valueOf(otWage));
                } else {
                    wage = employeeHours * 100;
                    txtWage.setText("P" + String.valueOf(wage));
                    txtRegularWage.setText("P" + String.valueOf(wage));
                }
                break;
            case "probationary":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    wage = (employeeHours * 100) + 720;
                    otWage = employeeHours * 100;

                    txtWage.setText("P" + String.valueOf(wage));
                    txtRegularWage.setText("P720");
                    txtOvertimeWage.setText("P" + String.valueOf(otWage));
                } else {
                    wage = employeeHours * 90;
                    txtWage.setText("P" + wage);
                    txtRegularWage.setText("P" + wage);
                }
                break;
            case "part-time":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    wage = (employeeHours * 90) + 600;
                    otWage = employeeHours * 90;

                    txtWage.setText("P" + String.valueOf(wage));
                    txtRegularWage.setText("P600");
                    txtOvertimeWage.setText("P" + String.valueOf(otWage));
                } else {
                    wage = employeeHours * 75;
                    txtWage.setText("P" + String.valueOf(wage));
                    txtRegularWage.setText("P" + String.valueOf(wage));
                }
                break;
        }

    }
        public void onClick(@NonNull View v) {
            if (v.getId() == R.id.btnBack) {
                startActivity(new Intent(ResultsScreen.this, MainActivity.class));
    }
}}