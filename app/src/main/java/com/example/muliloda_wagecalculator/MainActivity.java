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

        employeeName = findViewById(R.id.employeeName);
        hoursWorked = findViewById(R.id.hoursWorked);
        radioGroup = findViewById(R.id.radioGroup);
        btnCompute =findViewById(R.id.btnCompute);
        btnCompute.setOnClickListener(this);
    }

public void onClick(View v) {

    switch(v.getId()){
        case R.id.btnCompute:
            int selectedEmployeeType = radioGroup.getCheckedRadioButtonId();
            btnSelected = findViewById(selectedEmployeeType);

            String type = btnSelected.getText().toString();
            String hours = (hoursWorked.getText().toString());

            Intent intent = new Intent(this,ResultsScreen.class);

            intent.putExtra("radioGroup",type);
            intent.putExtra("hoursWorked",hours);
            startActivity(intent);

            break;

}
}}