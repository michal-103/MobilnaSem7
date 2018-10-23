package com.example.mobileeventapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReportActivity extends AppCompatActivity {



        private Button Traffic;
        private Button Kidnapping;
        private Button Robbery;
        private Button Back;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_report);

            Traffic = (Button) findViewById(R.id.buttonTraffic);
            Kidnapping = (Button) findViewById(R.id.buttonKidnapping);
            Robbery = (Button) findViewById(R.id.buttonRobbery);
            Back = (Button) findViewById(R.id.buttonBack);

            Traffic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = getApplicationContext();
                    //PersonUtils cpu = (PersonUtils) view.getTag();
                    Toast.makeText(context,"Traffic Accident Message Send" , Toast.LENGTH_SHORT).show();
                }
            });
            Kidnapping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = getApplicationContext();
                    //PersonUtils cpu = (PersonUtils) view.getTag();
                    Toast.makeText(context,"Kidnapping Message Send" , Toast.LENGTH_SHORT).show();

                }
            });
            Robbery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = getApplicationContext();
                    //PersonUtils cpu = (PersonUtils) view.getTag();
                    Toast.makeText(context,"Robbery Message Send" , Toast.LENGTH_SHORT).show();

                }
            });
            Back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent backIntent = new Intent(ReportActivity.this, MainMenuActivity.class);
                    startActivity(backIntent);
                }
            });
    }
}

