package com.example.loginregistration;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.loginregistration.NotifClass.CHANNEL_1_ID;
//import static com.codinginflow.notificationsexample.App.CHANNEL_2_ID;

import java.util.Calendar;

import static com.example.loginregistration.NotifClass.CHANNEL_1_ID;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker, btnNotify, mBackNotification;
    EditText txtDate, txtTime;
    private EditText eTitle, etContent;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        eTitle = findViewById(R.id.eTitle);
        etContent = findViewById(R.id.etContent);

        btnNotify = (Button)findViewById(R.id.btnNotify);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
        txtTime=(EditText)findViewById(R.id.in_time);

        ImageView mBackNotification = (ImageView) findViewById(R.id.mBackNotification);
        mBackNotification.setOnClickListener(view -> {
            Intent NotiftoMon = new Intent( NotificationActivity.this, MonitoringSystemActivity.class);
            startActivity(NotiftoMon);
        });
        //btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
    }


public void sendOnChannel1(View v) {
    btnNotify.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                String title = eTitle.getText().toString();
                String message = etContent.getText().toString();
                Notification notification = new NotificationCompat.Builder(NotificationActivity.this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(NotificationActivity.this);;
                notificationManager.notify(1, notification);
                }
            }
    );
}

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar a = Calendar.getInstance();
            mYear = a.get(Calendar.YEAR);
            mMonth = a.get(Calendar.MONTH);
            mDay = a.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
