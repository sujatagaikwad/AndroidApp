package com.example.shriramui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Order_displaylistview extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    OrderAdapter orderAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_displaylistview);
        orderAdapter=new OrderAdapter(this,R.layout.list_content);
        listView = (ListView) findViewById(R.id.listview);
        listView.setNestedScrollingEnabled(true);
        listView.setAdapter(orderAdapter);
        json_string = getIntent().getExtras().getString("json_data");

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray= jsonObject.getJSONArray("server_response");


            int count=0;
            String name,mobile,city,address,requirement;
            while (count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                name=JO.getString("name");
                city=JO.getString("city");
                address=JO.getString("address");
                mobile=JO.getString("mobile");
                requirement=JO.getString("requirement");
                Orders orders=new Orders(name,mobile,address,requirement,city);
                orderAdapter.add(orders);
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //this.listView.setItemsCanFocus(false);
//        this.listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
//
//                Intent shareIntent =new Intent();
//                shareIntent.setAction(Intent.ACTION_SEND);
//                shareIntent.putExtra(Intent.EXTRA_TEXT,"http://schemas.android.com/apk/res/android");
//                shareIntent.setType("text/plain");
//                startActivity(Intent.createChooser(shareIntent,"share via"));
//                }


      //  });
    }

}
