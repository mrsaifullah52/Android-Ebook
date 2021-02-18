package com.softtechglobal.vupapers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class papers extends AppCompatActivity {
    TextView subName;
    String shortCoder, codeNumer, file;

    Button File1,File2,File3,File4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);

        File1 = findViewById(R.id.File1);
        File2 = findViewById(R.id.File2);
        File3 = findViewById(R.id.File3);
        File4 = findViewById(R.id.File4);
        subName = findViewById(R.id.nameOfSub);

//        Bundle i = getIntent().getExtras();
//        shortCoder = i.getString("shortCode");
//        codeNumer = i.getString("codeNum");
//        file = i.getString("filetype");


//        final ArrayList<String> dataArray = new ArrayList<>();
//        try{
//            InputStream inputStream = getAssets().open(file);
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//            Document doc = documentBuilder.parse(inputStream);
//
//            NodeList nodeList1 = doc.getElementsByTagName(shortCoder);
//            Node node = nodeList1.item(0);
//            Element ele1 = (Element) node;
//
//            NodeList nodeList = ele1.getElementsByTagName(codeNumer);
//            for (int l=0; l<nodeList.getLength(); l++){
//
//                if (nodeList.item(0).getNodeType() == Node.ELEMENT_NODE){
//                    Element element = (Element) nodeList.item(l);
//                    dataArray.add(l, getNodeValue("link",element));
//
//                    Toast.makeText(papers.this,"link: "+dataArray.get(l),Toast.LENGTH_SHORT).show();
//                }
//            }
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }


        File1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(papers.this, pdfOpener.class);
//                intent.putExtra("url", dataArray.get(0));
                startActivity(intent);




            }
        });
        File2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(papers.this, pdfOpener.class);
////                intent.putExtra("url",dataArray.get(1));
                startActivity(intent);
            }
        });
        File3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(papers.this, pdfOpener.class);
//                intent.putExtra("url",dataArray.get(2));
                startActivity(intent);
            }
        });
        File4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(papers.this, pdfOpener.class);
////                intent.putExtra("url",dataArray.get(3));
                startActivity(intent);
            }
        });


    }



//
//    protected String getNodeValue(String tag, Element element) {
//        NodeList nodeList = element.getElementsByTagName(tag);
//        Node node = nodeList.item(0);
//        if(node!=null){
//            if(node.hasChildNodes()){
//                Node child = node.getFirstChild();
//                while (child!=null){
//                    if(child.getNodeType() == Node.TEXT_NODE){
//                        return  child.getNodeValue();
//                    }
//                }
//            }
//        }
//        return "";
//    }

}