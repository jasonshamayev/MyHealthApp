package com.example.loginregistration;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchResults extends AppCompatActivity {
    TextView resl;
    String resultValue;
    Button searchButton,doneSearching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageView mImg = (ImageView) findViewById(R.id.mBack);
        mImg.setOnClickListener(view -> {
            finish();
        });



        resl = (TextView)findViewById(R.id.result);
        resultValue = getIntent().getExtras().getString("resultvalue");
        resl.setText(resultValue);

        searchButton = findViewById(R.id.button4);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        doneSearching = findViewById(R.id.button5);
        doneSearching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(SearchResults.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });

    }
}