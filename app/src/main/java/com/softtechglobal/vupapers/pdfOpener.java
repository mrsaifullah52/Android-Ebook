package com.softtechglobal.vupapers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class pdfOpener extends AppCompatActivity {
    ProgressBar progressBar;
    PDFView pdfView;
    String Uri=null;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_opener);

        progressBar = findViewById(R.id.prBar);
        pdfView = findViewById(R.id.pdfOpener);
        tv = findViewById(R.id.tv);

//        Bundle intent = getIntent().getExtras();
//        Uri = intent.getString("url");


        pdfView.fromAsset("CS101File.pdf")
                .load();

//        pdfView.fromUri(android.net.Uri.parse(Uri))
//                .load();
//

//        new RelativePDfStream().execute(Uri);
    }



//    public void checkFolder() {
//        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/EZSol4VU/";
//        File dir = new File(path);
//        boolean isDirectoryCreated = dir.exists();
//        if (!isDirectoryCreated) {
//            isDirectoryCreated = dir.mkdir();
//            Log.d("Folder", "Created");
//        }
//        if (isDirectoryCreated) {
//            Log.d("Folder", "Already Created");
//        }
//        File file, file2;
//        FileOutputStream outputStream;
//        try {
//            file2 = new File(dir + "/Notes.docx");
//            if (!file2.exists()) {
//                file = new File(dir, "Notes.docx");
//                outputStream = new FileOutputStream(file);
//            }
//            Intent openFile = new Intent(Intent.ACTION_VIEW);
////            openFile.setDataAndType(Uri.parse(""));
////            openFile.addCategory(Intent.CATEGORY_OPENABLE);
//            Intent.createChooser(openFile, "Select a File to Upload");
//            startActivity(openFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    class RelativePDfStream extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection =(HttpURLConnection)url.openConnection();
                if (urlConnection.getResponseCode() == 200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }catch (IOException e){
                return null;
            }
            return inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            progressBar.setVisibility(View.VISIBLE);
            pdfView.fromStream(inputStream)
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            tv.setText(page+" / "+pageCount);
                        }
                    })
                    .onLoad(new OnLoadCompleteListener() {
                        @Override
                        public void loadComplete(int nbPages) {
                            progressBar.setVisibility(View.GONE);
                            tv.setVisibility(View.VISIBLE);
                        }
                    })
                    .load();
        }
    }
}