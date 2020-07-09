package com.example.vupapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    LinearLayout finalTerm,midTerm,currentPapers,download,writeToUs,aboutUs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        finalTerm = (LinearLayout) findViewById(R.id.finalTerm);
        midTerm = (LinearLayout) findViewById(R.id.midTerm);
        currentPapers = (LinearLayout) findViewById(R.id.currentPapers);
        download = (LinearLayout) findViewById(R.id.download);
        writeToUs = (LinearLayout) findViewById(R.id.writeToUs);
        aboutUs = (LinearLayout) findViewById(R.id.aboutUs);

        finalTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, finalTerm.class);
                startActivity(i);
            }
        });


        midTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, midTerm.class);
                startActivity(i);
            }
        });

        finalTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, finalTerm.class);
                startActivity(i);
            }
        });


        currentPapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, currentPapers.class);
                startActivity(i);
            }
        });


        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, download.class);
                startActivity(i);
            }
        });


        writeToUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, writeToUs.class);
                startActivity(i);
            }
        });


        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, aboutUs.class);
                startActivity(i);
            }
        });
    }
}
