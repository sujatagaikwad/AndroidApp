package com.example.shriramui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Refrigerator extends AppCompatActivity {
    private TextView mTextMessage;
    TextView txt_1,txt_2;
    Button Refribtn_1,Refribtn_2,Refribtn_3,Refribtn_4;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent I = new Intent(Refrigerator.this, Profile.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_profile:
//                    mTextMessage.setText(R.string.title_Profile);
                    I = new Intent(Refrigerator.this, Profile.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Booking:
//                    mTextMessage.setText(R.string.title_MyBooking);
                    I = new Intent(Refrigerator.this, Booking.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Help:
//                    mTextMessage.setText(R.string.title_HelpCenter);
                    Intent intent = new Intent(Refrigerator.this, Help.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_logout:
//                    mTextMessage.setText(R.string.title_Logout);
                    intent = new Intent(Refrigerator.this, Profile.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrigerator);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        txt_1= (TextView)findViewById(R.id.Refritxtview_1);
        txt_2= (TextView)findViewById(R.id.Refritxtview_2);
        Refribtn_1= (Button) findViewById(R.id.Refributton_1);
        Refribtn_2= (Button) findViewById(R.id.Refributton_2);
        Refribtn_3= (Button) findViewById(R.id.Refributton_3);
        Refribtn_4= (Button) findViewById(R.id.Refributton_4);
        Refribtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Refrigerator.this,Admin_refrigerator.class);
                startActivity(I);
            }
        });
        Refribtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Refrigerator.this,DoubleRefri.class);
                startActivity(I);
            }
        });
        Refribtn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Refrigerator.this,TripleRefri.class);
                startActivity(I);
            }
        });
        Refribtn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Refrigerator.this,SidebysideRefri.class);
                startActivity(I);
            }
        });
    }
}
