package com.softtechglobal.vupapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.material.bottomsheet.BottomSheetBehavior;
//import com.google.android.material.bottomsheet.BottomSheetDialog;

public class subjects extends AppCompatActivity {
    ListView lv3;
    String[] code3=null;
    String intentValue;
//    private static final String TAG = subjects.class.getSimpleName();
//    BottomSheetBehavior sheetBehavior;
//    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        lv3 = (ListView) findViewById(R.id.subjectList);

//        final View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
//        linearLayout = (LinearLayout) findViewById(R.id.llayout);
//        sheetBehavior = BottomSheetBehavior.from(linearLayout);

        Intent i = getIntent();
        int myValue = 1 + Integer.parseInt(i.getStringExtra("RowNum"));
        String myFileType = i.getStringExtra("type");
        Resources res = getResources();

        switch (myValue){
            case 1:
                code3 = res.getStringArray(R.array.ACC);
                intentValue = "ACC";
                break;

            case 2:
                code3 = res.getStringArray(R.array.BIF);
                intentValue = "BIF";
                break;
            case 3:
                code3 = res.getStringArray(R.array.BIO);
                intentValue = "BIO";
                break;
            case 4:
                code3 = res.getStringArray(R.array.BNK);
                intentValue = "BNK";
                break;
            case 5:
                code3 = res.getStringArray(R.array.CS);
                intentValue = "CS";
                break;
            case 6:
                code3 = res.getStringArray(R.array.ECO);
                intentValue = "ECO";
                break;
            case 7:
                code3 = res.getStringArray(R.array.EDU);
                intentValue = "EDU";
                break;
            case 8:
                code3 = res.getStringArray(R.array.ETH);
                intentValue = "ETH";
                break;
            case 9:
                code3 = res.getStringArray(R.array.ENG);
                intentValue = "ENG";
                break;
            case 10:
                code3 = res.getStringArray(R.array.FIN);
                intentValue = "FIN";
                break;
            case 11:
                code3 = res.getStringArray(R.array.GSC);
                intentValue = "GSC";
                break;
            case 12:
                code3 = res.getStringArray(R.array.HRM);
                intentValue = "HRM";
                break;
            case 13:
                code3 = res.getStringArray(R.array.ISL);
                intentValue = "ISL";
                break;
            case 14:
                code3 = res.getStringArray(R.array.IT);
                intentValue = "IT";
                break;
            case 15:
                code3 = res.getStringArray(R.array.MCD);
                intentValue = "MCD";
                break;
            case 16:
                code3 = res.getStringArray(R.array.MGT);
                intentValue = "MGT";
                break;
            case 17:
                code3 = res.getStringArray(R.array.MGMT);
                intentValue = "MGMT";
                break;
            case 18:
                code3 = res.getStringArray(R.array.MCM);
                intentValue = "MCM";
                break;
            case 19:
                code3 = res.getStringArray(R.array.MTH);
                intentValue = "MTH";
                break;
            case 20:
                code3 = res.getStringArray(R.array.MKT);
                intentValue = "MKT";
                break;
            case 21:
                code3 = res.getStringArray(R.array.PAK);
                intentValue = "PAK";
                break;
            case 22:
                code3 = res.getStringArray(R.array.PSY);
                intentValue = "PSY";
                break;
            case 23:
                code3 = res.getStringArray(R.array.PHY);
                intentValue = "PHY";
                break;
            case 24:
                code3 = res.getStringArray(R.array.PSC);
                intentValue = "PSC";
                break;
            case 25:
                code3 = res.getStringArray(R.array.SOC);
                intentValue = "SOC";
                break;
            case 26:
                code3 = res.getStringArray(R.array.STA);
                intentValue = "STA";
                break;
            case 27:
                code3 = res.getStringArray(R.array.URD);
                intentValue = "URD";
                break;
            default:
                Toast.makeText(subjects.this, "You have not selected any Subject",Toast.LENGTH_LONG).show();
                break;
        }

        if(code3!=null) {
            subjectAdapter adapter3 = new subjectAdapter(this, code3, intentValue, myFileType);
            lv3.setAdapter(adapter3);

        }


//        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//
//                TextView tv = (TextView) findViewById(R.id.codeTitle);
//                tv.setText(code3[Integer.parseInt(intentValue)]);
//
//                switch (newState){
//                    case BottomSheetBehavior.STATE_HIDDEN:
//                        break;
//                    case BottomSheetBehavior.STATE_EXPANDED: {
//                        tv.setText(code3[Integer.parseInt(intentValue)]);
//                    }break;
//                    case BottomSheetBehavior.STATE_COLLAPSED:
//                        break;
//                }
//
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//
//            }
//        });


    }

    public class subjectAdapter extends ArrayAdapter<String> {

        Context context;
        String[] subNams;
        String num, intentVal, fileType;

        subjectAdapter(Context c, String[] subNames, String intentVal, String fileType){
            super(c,R.layout.list,R.id.list_item1,subNames);

            this.context = c;
            this.subNams = subNames;
            this.intentVal = intentVal;
            this.fileType = fileType;
        }

        public class MySubjectHolder {
            TextView nam, lineNum;
            MySubjectHolder(View v) {
                nam = (TextView) v.findViewById(R.id.list_item1);
                lineNum = (TextView) v.findViewById(R.id.list_item2);
            }

       }

        public View getView(final int position, View convertView, ViewGroup parent){
            View row = convertView;
            MySubjectHolder holder=null;

            if(row == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.list, parent, false);
                holder = new MySubjectHolder(row);
                row.setTag(holder);
            }else {
                holder = (MySubjectHolder) row.getTag();
            }
            holder.nam.setText(subNams[position]);
            holder.lineNum.setText(String.valueOf(position+1));

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num = String.valueOf(position);
                    Intent i = new Intent(subjects.this, papers.class);
                    i.putExtra("codeNum",num);
                    i.putExtra("shortCode",intentVal);
                    i.putExtra("filetype",fileType);
                    context.startActivity(i);

//                    showBottomSheetDialog(subNams,num);
                }
            });

            return row;
        }
    }
//    public void showBottomSheetDialog(String[] first,String second){
//        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
//        TextView tv = (TextView) view.findViewById(R.id.codeTitle);
//        tv.setText(first[Integer.parseInt(second)]);
//        BottomSheetDialog dialog = new BottomSheetDialog(this);
//        dialog.setContentView(view);
//        dialog.show();
//    }

}