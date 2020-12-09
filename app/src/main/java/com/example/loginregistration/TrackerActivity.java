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

public class TrackerActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    ImageButton searchButton;
    EditText searchWord;
    String key;
    String medname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageView mImage = (ImageView) findViewById(R.id.mImageViewBack);
        mImage.setOnClickListener(view -> {
            Intent PersonalViewToHome = new Intent( TrackerActivity.this, HomeActivity.class);
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
                String dose = "";
                String days = "";
                StringBuffer buffer = new StringBuffer();
                Cursor cur = myDb.checkMedicationExist(myDb.currentUser.toString());

                if (cur.getCount() == 0) {
                    int i=0;
                    if(i==1)
                        Toast.makeText(TrackerActivity.this, "Please initialize vital sign values before using search function", Toast.LENGTH_LONG).show();
                    else
                    {
                        Toast.makeText(TrackerActivity.this, "Input didn't match any data :(", Toast.LENGTH_LONG).show();
                    }

                }
                else
                {

                    cur.moveToNext();
                    medname = cur.getString(0);

                    if (medname.equals(key.trim())) {
                        vsign = "Medication: " + cur.getString(0) + "\n" + "Dosage: " + cur.getString(1) + "\n" + "Days: " + cur.getString(2) + "\n";
                        ////dose = "Dosage: " + cur.getString(1) + "\n";
                        //days = "Days: " + cur.getString(2) + "\n";
                    }
                    else {
                        Toast.makeText(TrackerActivity.this, "Input didn't match any data :(", Toast.LENGTH_LONG).show();
                    }

                    if (vsign.length() > 0) {
                        Intent resultIntent = new Intent(TrackerActivity.this, TrackerResultActivity.class);
                        resultIntent.putExtra("resultvalue", vsign);

                        startActivity(resultIntent);
                    }
                }
            }

        });
    }
}