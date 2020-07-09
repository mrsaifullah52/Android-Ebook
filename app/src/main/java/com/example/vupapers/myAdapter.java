package com.example.vupapers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class myAdapter extends ArrayAdapter<String> {
    Context context;
    String[] subNam;
    String num, type;

    public myAdapter(Context c, String[] subName, String type){
        super(c,R.layout.list,R.id.list_item1,subName);

        this.context = c;
        this.subNam = subName;
        this.type = type;
    }

    public class MyHolder{
        TextView nam;

        MyHolder(View v){
            nam = (TextView) v.findViewById(R.id.list_item1);
        }
    }
    public View getView(final int position, View convertView, ViewGroup parent){
        View row = convertView;
        myAdapter.MyHolder holder=null;

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list, parent, false);
            holder = new myAdapter.MyHolder(row);
            row.setTag(holder);
        }else {
            holder = (myAdapter.MyHolder) row.getTag();
        }
        holder.nam.setText(subNam[position]);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = String.valueOf(position);
                Intent i = new Intent(context, subjects.class);
                i.putExtra("type",type);
                i.putExtra("RowNum",num);
                context.startActivity(i);
            }
        });

        return row;
    }
}
