package com.softtechglobal.vupapers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.TextView;


public class contentDetail extends AppCompatActivity {
//    TextView tv;
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);

        wv = (WebView) findViewById(R.id.webView);



//        tv = (TextView) findViewById(R.id.dataTV);
//
        Bundle i = getIntent().getExtras();
        wv.loadData(i.getString("id"),"text/html","UTF-8");
//        Spanned spanned = Html.fromHtml(i.getString("id"));
//        char[] chars = new char[spanned.length()];
//        TextUtils.getChars(spanned, 0, spanned.length(), chars, 0);
//        String plainText = new String(chars);
//        tv.setText(plainText);
    }
}