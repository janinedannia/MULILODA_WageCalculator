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
        double totalWage = 0.0;
        double totalOTWage = 0.0;

        switch (employeeType) {
            case "regular":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 115) + 800;
                    totalOTWage = employeeHours * 115;

                    txtWage.setText("P" + (totalWage));
                    txtRegularWage.setText("P800");
                    txtOvertimeWage.setText("P" + totalOTWage);
                } else {
                    totalWage = employeeHours * 100;
                    txtWage.setText("P" + (totalWage));
                    txtRegularWage.setText("P" + totalWage);
                }
                break;
            case "probationary":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 100) + 720;
                    totalOTWage = employeeHours * 100;

                    txtWage.setText("P" + (totalWage));
                    txtRegularWage.setText("P720");
                    txtOvertimeWage.setText("P" + totalOTWage);
                } else {
                    totalWage = employeeHours * 90;
                    txtWage.setText("P" + totalWage);
                    txtRegularWage.setText("P" + totalWage);
                }
                break;
            case "part-time":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 90) + 600;
                    totalOTWage = employeeHours * 90;

                    txtWage.setText("P" + (totalWage));
                    txtRegularWage.setText("P600");
                    txtOvertimeWage.setText("P" + totalOTWage);
                } else {
                    totalWage = employeeHours * 75;
                    txtWage.setText("P" + totalWage);
                    txtRegularWage.setText("P" + totalWage);
                }
                break;
        }

    }
        public void onClick(@NonNull View v) {
            if (v.getId() == R.id.btnBack) {
                startActivity(new Intent(ResultsScreen.this, MainActivity.class));
    }
}}