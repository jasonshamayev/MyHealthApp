package com.example.loginregistration;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Search extends AppCompatActivity {
    DatabaseHelper myDb;
    ImageButton searchButton;
    EditText searchWord;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageView mImage = (ImageView) findViewById(R.id.mImageViewBack);
        mImage.setOnClickListener(view -> {
            Intent PersonalViewToHome = new Intent( Search.this, HomeActivity.class);
            startActivity(PersonalViewToHome);
        });


        myDb = new DatabaseHelper(this);

        searchButton = (ImageButton) findViewById(R.id.imageButtonSearch);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchWord = (EditText) findViewById(R.id.keyword);
                key = searchWord.getText().toString();

                String vsign = "";
                StringBuffer buffer = new StringBuffer();


                Cursor cur = myDb.checkVitalSignsExist(myDb.currentUser.toString());

                if (("username".toLowerCase()).equals(key.toLowerCase().trim()))
                {

                    vsign = "Username: " + myDb.currentUser.toString();

                    Intent resultIntent = new Intent(Search.this, SearchResults.class);
                    resultIntent.putExtra("resultvalue", vsign);
                    startActivity(resultIntent);
                }


               else if (cur.getCount() == 0) {
                    int i=0;

                    if (("Cholesterol".toLowerCase()).equals(key.toLowerCase().trim()))
                    {
                        i=1;
                    }
                    else if (("Heart rate".toLowerCase()).equals(key.toLowerCase().trim()))
                    {
                        i=1;
                    }
                    else if (("Blood Pressure".toLowerCase()).equals(key.toLowerCase().trim()))
                    {
                        i=1;
                    }
                    else if (("Glucose".toLowerCase()).equals(key.toLowerCase().trim()))
                    {
                        i=1;
                    }

                    if(i==1)
                    Toast.makeText(Search.this, "Please initialize vital sign values before using search function", Toast.LENGTH_LONG).show();
                    else
                    {
                        Toast.makeText(Search.this, "Input didn't match any data :(", Toast.LENGTH_LONG).show();
                    }

                }
                else
                {

                    cur.moveToNext();



                if (("Cholesterol".toLowerCase()).equals(key.toLowerCase().trim())) {
                    vsign = "Cholestrol: " + cur.getString(0) + "(cal)";

                } else if (("Heart rate".toLowerCase()).equals(key.toLowerCase().trim())) {
                    vsign = "Heart rate: " + cur.getString(4) + "(bpm)";

                } else if (("Blood Pressure".toLowerCase()).equals(key.toLowerCase().trim())) {
                    vsign = "Systolic Blood Pressure: " + cur.getString(1) + "(mmHg)" + "\n" + "Diastolic Blood Pressure: " + cur.getString(2) + "(mmHg)";
                } else if (("Glucose".toLowerCase()).equals(key.toLowerCase().trim())) {
                    vsign = "Glucose: " + cur.getString(3) + "(mg/dL)";

                } else if (("username".toLowerCase()).equals(key.toLowerCase().trim())) {
                    vsign = "Username: " + myDb.currentUser.toString();

                }

                else {
                    Toast.makeText(Search.this, "Input didn't match any data :(", Toast.LENGTH_LONG).show();
                }

                if (vsign.length() > 0) {
                    Intent resultIntent = new Intent(Search.this, SearchResults.class);
                    resultIntent.putExtra("resultvalue", vsign);

                    startActivity(resultIntent);
                }
            }
            }

        });



    }
}




















