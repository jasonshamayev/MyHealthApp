package com.example.loginregistration;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewInformation extends AppCompatActivity {

    DatabaseHelper myDb;

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4,tv5;

    int printHeartRate;
    int cholestrol;
    int glucoseLevel;
    int bloodPressure;
    int diastolic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_information);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        ImageView reviewB = (ImageView) findViewById(R.id.reviewBack);
        reviewB.setOnClickListener(view -> {
            finish();
        });


        myDb = new DatabaseHelper(this);



        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);

        printHeartRate = getIntent().getExtras().getInt("value1");
        tv1.setText("Heart Rate: "+String.valueOf(printHeartRate));

        cholestrol = getIntent().getExtras().getInt("value2");
        tv2.setText("Cholestrol: "+String.valueOf(cholestrol));

        glucoseLevel = getIntent().getExtras().getInt("value3");
        tv3.setText("Glucose Level: "+String.valueOf(glucoseLevel));

        bloodPressure = getIntent().getExtras().getInt("value4");
        tv4.setText("Systolic BP: "+String.valueOf(bloodPressure));

        diastolic= getIntent().getExtras().getInt("value5");
        tv5.setText("  Diastolic BP: "+String.valueOf(diastolic));

        Button makeChanges = (Button)findViewById(R.id.button3);
        makeChanges.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
        Button submit = (Button)findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor data = myDb.checkVitalSignsExist(myDb.currentUser.toString()); ////
                if(data.getCount()==0) {
                    addSigns();
                }
                else {
                    updateSigns();
                }
                data.close();
                Intent mainIntent = new Intent(ReviewInformation.this, HomeActivity.class);
                startActivity(mainIntent);

            }
        });




    }

    public void addSigns()
    {
        boolean insertTrue = myDb.addVitalSigns(myDb.currentUser.toString(),String.valueOf(printHeartRate),String.valueOf(cholestrol),String.valueOf(glucoseLevel),String.valueOf(bloodPressure),String.valueOf(diastolic));
        //      boolean insertTrue = myDb.addVitalSigns("12","13","14","15");
        if(insertTrue==true)
        {
            Toast.makeText(ReviewInformation.this,"Data Inserted!",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(ReviewInformation.this,"Data not Inserted!",Toast.LENGTH_LONG).show();

    }

    public void updateSigns()
    {
        boolean insertTrue = myDb.updateVitalSigns(myDb.currentUser.toString(),String.valueOf(printHeartRate),String.valueOf(cholestrol),String.valueOf(glucoseLevel),String.valueOf(bloodPressure),String.valueOf(diastolic));
        if(insertTrue==true)
        {
            Toast.makeText(ReviewInformation.this,"Data updated!",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(ReviewInformation.this,"Data not updated!",Toast.LENGTH_LONG).show();
    }
}