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


    TextView txtTotalWage;
    TextView txtOTWage;
    TextView txtRegularWage;
    TextView txtHours;
    TextView txtOvertimeHours;
    String EmployeeName, EmployeeType;
    Double EmployeeHours;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        txtTotalWage = findViewById(R.id.totalWageValue);
        txtOTWage = findViewById(R.id.totalOvertimeValue);
        txtRegularWage = findViewById(R.id.totalRegularValue);
        txtHours = findViewById(R.id.hoursRenderedValue);
        txtOvertimeHours = findViewById(R.id.hoursOvertimeValue);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        Intent i = getIntent();

       EmployeeType = i.getStringExtra("type");
       EmployeeName = i.getStringExtra("empName");
       EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));
       txtOvertimeHours.setText(String.valueOf(EmployeeHours - 8));
       txtHours.setText(String.valueOf(EmployeeHours));
       calcWage(EmployeeType, EmployeeHours, txtTotalWage, txtRegularWage, txtOvertimeHours);

    }

    @SuppressLint("SetTextI18n")
    public void calcWage(String employeeType, Double employeeHours, TextView txtTotalWage, TextView txtRegularWage, TextView txtOTWage) {
        double totalWage = 0.0;
        double totalOTWage = 0.0;

        switch (employeeType) {
            case "Regular":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 115) + 800;
                    totalOTWage = employeeHours * 115;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱800");
                    txtOTWage.setText("₱" + totalOTWage);
                } else {
                    totalWage = employeeHours * 100;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Part-Time":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 90) + 600;
                    totalOTWage = employeeHours * 90;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱600");
                    txtOTWage.setText("₱" + totalOTWage);
                } else {
                    totalWage = employeeHours * 75;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Probationary":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 100) + 720;
                    totalOTWage = employeeHours * 100;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱720");
                    txtOTWage.setText("₱" + totalOTWage);
                } else {
                    totalWage = employeeHours * 90;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
        }
    }

    public void onClick(@NonNull View v) {
        if (v.getId() == R.id.btnBack) {
            startActivity(new Intent(ResultsScreen.this, MainActivity.class));
        }
    }
}