package com.example.vupapers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;


public class contentDetail extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);

        tv = (TextView) findViewById(R.id.dataTV);

        Bundle i = getIntent().getExtras();

        String data = i.getString("id");
        data.replaceAll("<p>","");
        data.replaceAll("</p>","");
        data.replaceAll("<br>","\n");

        tv.setText(data);

    }
}
