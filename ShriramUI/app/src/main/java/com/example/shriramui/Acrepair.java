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

public class Acrepair extends AppCompatActivity {
    TextView txt_1,txt_2;
    Button Acbtn_1, Acbtn_2;
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent I = new Intent(Acrepair.this, Profile.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_profile:
//                    mTextMessage.setText(R.string.title_Profile);
                    I = new Intent(Acrepair.this, Profile.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Booking:
//                    mTextMessage.setText(R.string.title_MyBooking);
                    I = new Intent(Acrepair.this, Booking.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Help:
//                    mTextMessage.setText(R.string.title_HelpCenter);
                    Intent intent = new Intent(Acrepair.this, Help.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_logout:
//                    mTextMessage.setText(R.string.title_Logout);
                    intent = new Intent(Acrepair.this, Profile.class);
                    startActivity(intent);
                    finish();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acrepair);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        txt_1= (TextView)findViewById(R.id.textview_1);
        txt_2= (TextView)findViewById(R.id.textview_2);
        Acbtn_1= (Button) findViewById(R.id. Acbutton_1);
        Acbtn_2= (Button) findViewById(R.id. Acbutton_2);
        Acbtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Acrepair.this,Admin_AC.class);
                startActivity(I);
            }
        });
        Acbtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Acrepair.this,SplitAc.class);
                startActivity(I);
            }
        });
    }
}
