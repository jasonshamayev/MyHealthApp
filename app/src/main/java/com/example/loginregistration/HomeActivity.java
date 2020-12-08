package com.example.loginregistration;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;

import java.util.Set;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton mButtonPersonalInfo = (ImageButton) findViewById(R.id.imageButton_PersonalInfo);
        ImageButton mButtonMedication = (ImageButton) findViewById(R.id.imageButton_Medicine);
        ImageButton mButtonSettings = (ImageButton) findViewById(R.id.imageButton_Settings);

        ImageButton mButtonVitalSigns = (ImageButton) findViewById(R.id.imageButton_vitalSigns);
        ImageButton mButtonSearch = (ImageButton) findViewById(R.id.imageButton_search);

        ImageButton mButtonMonitoringSystem = (ImageButton) findViewById(R.id.imageButton_MonitoringSystem);

        ImageButton mButtonDiet = (ImageButton) findViewById(R.id.imageButton_Diet);
        ImageButton mButtonComm = (ImageButton) findViewById(R.id.imageButton_Communication);


        mButtonMedication.setOnClickListener(view -> {
            Intent medicationIntent = new Intent(HomeActivity.this, ViewMedicationActivity.class);
            startActivity(medicationIntent);
        });

        mButtonPersonalInfo.setOnClickListener(view -> {
            Intent personalInfoIntent = new Intent(HomeActivity.this, PersonalInfoActivity.class);
            startActivity(personalInfoIntent);
        });

        mButtonSettings.setOnClickListener(v -> {
            Intent SettingsIntent = new Intent(HomeActivity.this,SettingsActivity.class);
            startActivity(SettingsIntent);
        });

        mButtonVitalSigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vitalSignsIntent = new Intent(HomeActivity.this, VitalSigns.class);
                startActivity(vitalSignsIntent);
            }
        });
        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(HomeActivity.this, Search.class);
                startActivity(searchIntent);
                                        }
        });


        mButtonMonitoringSystem.setOnClickListener(v -> {
            Intent monitoringSystemIntent = new Intent(HomeActivity.this, MonitoringSystemActivity.class);
            startActivity(monitoringSystemIntent);

        });

        mButtonDiet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent dietInfoIntent = new Intent(HomeActivity.this, DietActivity.class);
                startActivity(dietInfoIntent);
            }

        });

        mButtonComm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent comInfoIntent = new Intent(HomeActivity.this, CommunicationsActivity.class);
                startActivity(comInfoIntent);
            }

        });
    }
}
