package com.softtechglobal.vupapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    LinearLayout finalTerm,midTerm,currentPapers,download,writeToUs,aboutUs;
    TextView myDailyQoute;
    Calendar calendar=Calendar.getInstance();
    String qoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDailyQoute = (TextView) findViewById(R.id.myQuote);

        finalTerm = (LinearLayout) findViewById(R.id.finalTerm);
        midTerm = (LinearLayout) findViewById(R.id.midTerm);
        currentPapers = (LinearLayout) findViewById(R.id.currentPapers);
        download = (LinearLayout) findViewById(R.id.download);
        writeToUs = (LinearLayout) findViewById(R.id.writeToUs);
        aboutUs = (LinearLayout) findViewById(R.id.aboutUs);


        //Daily Qoute

        try {
            JSONObject obj1 = new JSONObject(loadJsonfromAsset());
            JSONArray objArray = obj1.getJSONArray(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            JSONObject obj2 = objArray.getJSONObject(0);
            qoute = obj2.getString("text");

            myDailyQoute.setText('"'+qoute+'"');

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("myValueYar", e.toString());
        }

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


    public String loadJsonfromAsset(){
        String json = null;
        try{
            InputStream is = getAssets().open("qoute.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        Log.d("Myerror Json var: ",json);
        return json;
    }
}