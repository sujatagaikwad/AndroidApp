package com.example.shriramui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Help extends AppCompatActivity {
    private TextView mTextMessage;

   CardView card_1,card_2,card_3;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent I = new Intent(Help.this, Home.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_profile:
//                    mTextMessage.setText(R.string.title_Profile);
                    I = new Intent(Help.this, Profile.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Booking:
//                    mTextMessage.setText(R.string.title_MyBooking);
                    I = new Intent(Help.this, Booking.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Help:
//                    mTextMessage.setText(R.string.title_HelpCenter);
                    Intent intent = new Intent(Help.this, Help.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_logout:
//                    mTextMessage.setText(R.string.title_Logout);
                    intent = new Intent(Help.this, Profile.class);
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
        setContentView(R.layout.activity_help);
                getSupportActionBar().setTitle("Information_Service center");
                BottomNavigationView navView = findViewById(R.id.nav_view);
                mTextMessage = findViewById(R.id.message);
                navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
                card_1=(CardView)findViewById(R.id.Cardemail);
                card_2=(CardView)findViewById(R.id.cardphone);
        card_3=(CardView)findViewById(R.id.cardshare);
        card_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_SEND);
                I.putExtra(Intent.EXTRA_EMAIL,new String[]{"rahulkhatkale22@gmail.com"});
                I.putExtra(Intent.EXTRA_SUBJECT,"Your Problems");
                I.putExtra(Intent.EXTRA_TEXT,"How can We help you");
                I.setType("message/rfc822");
                startActivity(I);
            }
        });
        card_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(Intent.ACTION_DIAL);
                I.setData(Uri.parse("tel:8855039694"));
                startActivity(I);
            }
        });
        card_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent =new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,"http://shiramss.com/");
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent,"share via"));
            }
        });
    }
}
