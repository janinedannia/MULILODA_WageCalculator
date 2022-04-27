package com.example.muliloda_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import javax.xml.transform.Result;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView employeeName, hoursWorked;
    RadioGroup radioGroup;
    Button btnCompute;
    RadioButton btnSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeName = findViewById(R.id.name);
        hoursWorked = findViewById(R.id.hours);
        radioGroup = findViewById(R.id.radioGroup);
        btnCompute =findViewById(R.id.btnCompute);
        btnCompute.setOnClickListener(this);
    }

public void onClick(View v) {

    if (v.getId() == R.id.btnCompute) {
            int selectedEmployeeType = radioGroup.getCheckedRadioButtonId();
            btnCompute = findViewById(selectedEmployeeType);

            String type = btnCompute.getText().toString();
            String name = employeeName.getText().toString();
            String hours = ( hoursWorked.getText().toString() );

            Intent intent = new Intent(this,ResultsScreen.class);

            intent.putExtra("type",type);
            intent.putExtra("hours", hours);
            intent.putExtra("employeeName", name);
            startActivity(intent);

}
}}