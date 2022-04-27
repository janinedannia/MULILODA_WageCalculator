package com.example.muliloda_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView employeeName, hoursWorked;
    RadioGroup radioGroup;
    RadioButton btnSelected;
    Button Compute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeName = findViewById(R.id.name);
        hoursWorked = findViewById(R.id.hours);

        radioGroup = findViewById(R.id.radioGroup);

        Compute = findViewById(R.id.Compute);
        Compute.setOnClickListener(this);
    }

    public void onClick(View v) {


       switch(v.getId()){
           case R.id.Compute:
            int selectedEmployeeType = radioGroup.getCheckedRadioButtonId();

            Compute = findViewById(selectedEmployeeType);

            String type = Compute.getText().toString();

            String name = employeeName.getText().toString();
            String hours = (hoursWorked.getText().toString());

            Intent intent = new Intent(MainActivity.this,ResultsScreen.class);

            intent.putExtra("type", type);
            intent.putExtra("hours", hours);
            intent.putExtra("empName",name);
            startActivity(intent);

            break;
        }
    }
}

