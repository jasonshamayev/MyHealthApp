package com.example.loginregistration;

        import androidx.appcompat.app.ActionBar;
        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

public class TrackerResultActivity extends AppCompatActivity {
    TextView resl;
    String resultValue;
    Button donebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker_result);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageView mImg = (ImageView) findViewById(R.id.mBack);
        mImg.setOnClickListener(view -> {
            finish();
        });

        resl = (TextView)findViewById(R.id.result);
        resultValue = getIntent().getExtras().getString("resultvalue");
        resl.setText(resultValue);

        donebtn = findViewById(R.id.donebtn);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(TrackerResultActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });

    }
}