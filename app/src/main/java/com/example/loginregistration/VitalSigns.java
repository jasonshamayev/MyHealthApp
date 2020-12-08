package com.example.loginregistration;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VitalSigns extends AppCompatActivity {
    DatabaseHelper myDb;

    EditText e1,e2,e3,e4,e5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_signs);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        myDb = new DatabaseHelper(this);



        e1 = findViewById(R.id.reading1);
        e2 = findViewById(R.id.reading2);
        e3 = findViewById(R.id.reading3);
        e4 = findViewById(R.id.reading4);
        e4.setHint("Systolic");
        e5 = findViewById(R.id.reading4b);
        e5.setHint("Diastolic");
        Button next = findViewById(R.id.button);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                openActivity();
            }
        });







    }
    public void openActivity() {
        final EditText firstReading = findViewById(R.id.reading1);
        final EditText secondReading = findViewById(R.id.reading2);
        final EditText thirdReading = findViewById(R.id.reading3);
        final EditText fourthReading = findViewById(R.id.reading4);
        final EditText fifthReading = findViewById(R.id.reading4b);


        if ((firstReading.length() == 0) || (secondReading.length() == 0) || (thirdReading.length() == 0) || (fourthReading.length() == 0) || (fifthReading.length() == 0))
            Toast.makeText(VitalSigns.this, "Please fill in all the required fields correctly!", Toast.LENGTH_LONG).show();
        else {


            int heartRate = Integer.parseInt(firstReading.getText().toString());
            int cholestrol = Integer.parseInt(secondReading.getText().toString());
            int glucoseLevel = Integer.parseInt(thirdReading.getText().toString());
            int bloodPressure = Integer.parseInt(fourthReading.getText().toString());
            int diastolic = Integer.parseInt(fifthReading.getText().toString());

            if((heartRate<1)||(heartRate>220))
                Toast.makeText(VitalSigns.this, "Heart Rate is out of range!", Toast.LENGTH_LONG).show();
            else if((bloodPressure<1)||(bloodPressure>200))
            {
                Toast.makeText(VitalSigns.this, "Systolic Blood Pressure is out of range!", Toast.LENGTH_LONG).show();

            }

            else if((diastolic<1)||(diastolic>350))
            {
                Toast.makeText(VitalSigns.this, "Diastolic Blood Pressure is out of range!", Toast.LENGTH_LONG).show();

            }
            else if((glucoseLevel<1)||(glucoseLevel>1500))
            {
                Toast.makeText(VitalSigns.this, "Glucose level is out of range!", Toast.LENGTH_LONG).show();
            }
            else if((cholestrol<1)||(cholestrol>1500))
            {
                Toast.makeText(VitalSigns.this, "Cholesterol is out of range!", Toast.LENGTH_LONG).show();

            }
            else {
                Intent downloadIntent = new Intent(this, ReviewInformation.class);
                downloadIntent.putExtra("value1", heartRate);
                downloadIntent.putExtra("value2", cholestrol);
                downloadIntent.putExtra("value3", glucoseLevel);
                downloadIntent.putExtra("value4", bloodPressure);
                downloadIntent.putExtra("value5", diastolic);

                startActivity(downloadIntent);
            }

        }

    }
}