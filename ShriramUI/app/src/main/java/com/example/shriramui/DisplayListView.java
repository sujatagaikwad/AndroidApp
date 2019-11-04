package com.example.shriramui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
String json_string;
JSONObject jsonObject;
JSONArray jsonArray;
ContactAdapter contactAdapter;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        contactAdapter=new ContactAdapter(this,R.layout.row_layout);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(contactAdapter);
        listView.setNestedScrollingEnabled(true);
        json_string = getIntent().getExtras().getString("json_data");

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray= jsonObject.getJSONArray("server_response");


            int count=0;
            String name,mobile,email;
            while (count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                name=JO.getString("name");
                mobile=JO.getString("mobile");
                email=JO.getString("email");
                Contacts contacts=new Contacts(name,mobile,email);
                contactAdapter.add(contacts);
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
