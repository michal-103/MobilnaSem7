package com.example.mobileeventapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    private Button Map;
    private Button Report;
    private Button Settings;
    private Button Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Map = (Button) findViewById(R.id.buttonMap);
        Report = (Button) findViewById(R.id.buttonReport);
        Settings = (Button) findViewById(R.id.buttonSettings);
        Exit = (Button) findViewById(R.id.buttonExit);

        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(MainMenuActivity.this, MapActivity.class);
                startActivity(mapIntent);
            }
        });

        Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reportIntent = new Intent(MainMenuActivity.this, ReportActivity.class);
                startActivity(reportIntent);
            }
        });

        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }
}
