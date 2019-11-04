package com.example.shriramui;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Home extends AppCompatActivity {
    private TextView mTextMessage;

    androidx.cardview.widget.CardView txt_1,txt_2,txt_3,txt_4,txt_5;
    ViewFlipper v_Fipper;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
 //                   mTextMessage.setText(R.string.title_Profile);
                    Intent I = new Intent(Home.this,User_Registration.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Booking:
   //                mTextMessage.setText(R.string.title_MyBooking);
                    I = new Intent(Home.this, Booking.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Help:
     //               mTextMessage.setText(R.string.title_HelpCenter);
                    Intent intent = new Intent(Home.this, Help.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_logout:
       //             mTextMessage.setText(R.string.title_Logout);

                    intent = new Intent(Home.this, Login_Form.class);
                    startActivity(intent);
                    Toast.makeText(Home.this, "Log Out Successfully", Toast.LENGTH_LONG).show();

                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        txt_1= (androidx.cardview.widget.CardView)findViewById(R.id.machincard);
        txt_2= (androidx.cardview.widget.CardView)findViewById(R.id.refrigeratorcard);
        txt_3= (androidx.cardview.widget.CardView)findViewById(R.id.accard);
        txt_4= (androidx.cardview.widget.CardView)findViewById(R.id.microcard);
        txt_5= (androidx.cardview.widget.CardView)findViewById(R.id.rocard);
        txt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Washingmachine.class);
                startActivity(intent);
            }
        });
        txt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Refrigerator.class);
                startActivity(intent);
            }
        });
        txt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Acrepair.class);
                startActivity(intent);
            }
        });
        txt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Microwave.class);
                startActivity(intent);
            }
        });
        txt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Rowater.class);
                startActivity(intent);
            }
        });


        int image[]={R.drawable.slide_1,R.drawable.slide_2,R.drawable.slide_3,R.drawable.slide_4};

        v_Fipper= findViewById(R.id.v_Fipper);


        for (int i =0; i< image.length;i++){
            flipperImages(image[i]);
        }
        // for (int image:images){
        //flipperImages(image);
        //}
    }
    public void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        v_Fipper.addView(imageView);
        v_Fipper.setFlipInterval(2000);
        v_Fipper.setAutoStart(true);

        v_Fipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_Fipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }

}
