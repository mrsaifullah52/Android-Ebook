package com.example.vupapers;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;


public class currentPapers extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_papers);

        lv = (ListView) findViewById(R.id.currentPapersList);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "http://member.fhenergygroup.com/wp-json/wp/v2/posts?_fields=id,title.rendered,content.rendered";

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String[] ids = new String[response.length()];
                String[] titles = new String[response.length()];

                for (int i=0; i<=response.length()-1;i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        JSONObject titleObj = jsonObject.getJSONObject("title");
                        JSONObject bodyObj = jsonObject.getJSONObject("content");

                        String objId = jsonObject.getString("id");
                        String objTitle = titleObj.getString("rendered");
                        String objContent = bodyObj.getString("rendered");

                        ids[i] = objContent;
                        titles[i] = objTitle;


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("MyJson error",e.toString());
                        Toast.makeText(currentPapers.this,"We are failed in fetching", Toast.LENGTH_SHORT).show();
                        Toast.makeText(currentPapers.this,e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }

                DataAdapter dataAdapter = new DataAdapter(currentPapers.this, titles, ids);
                lv.setAdapter(dataAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error Response", error.toString());
                Toast.makeText(currentPapers.this,"Error Response", Toast.LENGTH_SHORT).show();
                Toast.makeText(currentPapers.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }






//    public String loadJsonfromAsset(){
//        String json = null;
//        try{
//            InputStream is = getAssets().open("data.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException ex){
//            ex.printStackTrace();
//            return null;
//        }
//        Log.d("Myerror Json var: ",json);
//        return json;
//    }


    public class DataAdapter extends ArrayAdapter<String> {

        Context context;
        String[] titles, id;
        String num;

        DataAdapter(Context c, String[] titles, String[] ids){
            super(c,R.layout.list,R.id.list_item1, titles);

            this.context = c;
            this.titles = titles;
            this.id = ids;
        }

        public class MyDataHolder {
            TextView nam;
            MyDataHolder(View v) {
                nam = (TextView) v.findViewById(R.id.list_item1);
            }
        }

        public View getView(final int position, View convertView, ViewGroup parent){
            View row = convertView;
            MyDataHolder holder=null;

            if(row == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.list, parent, false);
                holder = new MyDataHolder(row);
                row.setTag(holder);
            }else {
                holder = (MyDataHolder) row.getTag();
            }
            holder.nam.setText(titles[position]);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num = String.valueOf(position);
                    Intent i = new Intent(currentPapers.this, contentDetail.class);
                    i.putExtra("position",num);
                    i.putExtra("id",id[position]);

                    context.startActivity(i);
                }
            });

            return row;
        }
    }
}
