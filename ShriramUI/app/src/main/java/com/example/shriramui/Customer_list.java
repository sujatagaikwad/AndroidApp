package com.example.shriramui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Customer_list extends AppCompatActivity {
     Button BTn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        BTn_1 = (Button)findViewById(R.id.btnregi);
        btn_2 = (Button)findViewById(R.id.oder_btn);
        btn_3 = (Button)findViewById(R.id.washing_btn);
        btn_4 = (Button)findViewById(R.id.Re_btn);
        btn_5 = (Button)findViewById(R.id.Ac_btn);
        btn_6 = (Button)findViewById(R.id.micro_btn);
        btn_7= (Button)findViewById(R.id.ro_btn);
        BTn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_list.this,Register.class);
                startActivity(intent);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_list.this,Lastorderlist.class);
                startActivity(intent);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_list.this,Changeprice_washing.class);
                startActivity(intent);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_list.this,Changeprice_refrigerator.class);
                startActivity(intent);
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_list.this,Changeprice_ac.class);
                startActivity(intent);
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_list.this,Changeprice_micro.class);
                startActivity(intent);
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_list.this,Changeprice_rowater.class);
                startActivity(intent);
            }
        });
    }
}
