package com.example.mobileeventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ReportActivity extends AppCompatActivity {


        public String nameOfEvent;
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
                    Intent intent = new Intent(ReportActivity.this, ReportPageActivity.class);
                    nameOfEvent = "Traffic Accident";
                    intent.putExtra("type",nameOfEvent);
                    startActivity(intent);
                        }
            });
            Kidnapping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReportActivity.this, ReportPageActivity.class);
                    nameOfEvent = "Kidnapping";
                    intent.putExtra("type",nameOfEvent);
                    startActivity(intent);


                }
            });
            Robbery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReportActivity.this, ReportPageActivity.class);
                    nameOfEvent = "Robbery";
                    intent.putExtra("type",nameOfEvent);
                    startActivity(intent);

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

