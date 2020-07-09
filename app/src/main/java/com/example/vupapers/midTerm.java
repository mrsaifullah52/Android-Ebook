package com.example.vupapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

public class midTerm extends AppCompatActivity {
    ListView lv;
    String[] code;
    String type="midterm.xml";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_term);
        lv = (ListView) findViewById(R.id.midtermList);

        Resources res = getResources();
        code = res.getStringArray(R.array.backCodes);

        myAdapter adapter = new myAdapter(this, code,type);
        lv.setAdapter(adapter);
    }
}
