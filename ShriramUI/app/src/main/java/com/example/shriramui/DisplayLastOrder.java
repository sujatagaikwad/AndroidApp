package com.example.shriramui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayLastOrder extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    LastorderAdapter lastorderAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_last_order);
        lastorderAdapter=new LastorderAdapter(this,R.layout.list_child);
        listView = (ListView) findViewById(R.id.listview);
        listView.setNestedScrollingEnabled(true);
        listView.setAdapter(lastorderAdapter);
        json_string = getIntent().getExtras().getString("json_data");

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray= jsonObject.getJSONArray("server_response");


            int count=0;
            String id, name,mobileno,address,washingtextview,Repairprice;
            while (count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                id=JO.getString("id");
                name=JO.getString("name");
                address=JO.getString("address");
                mobileno=JO.getString("mobileno");
                washingtextview=JO.getString("washingtextview");
                Repairprice=JO.getString("Repairprice");
                Last_order last_order=new Last_order(id,name,address,mobileno,washingtextview,Repairprice);
                lastorderAdapter.add(last_order);
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
