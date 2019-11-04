package com.example.shriramui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SplitAc extends AppCompatActivity {
    private ImageView img;
TextView txt_1,txt_2,txt_3;
    androidx.cardview.widget.CardView card_1,card_2,card_3;
    private TextView mTextMessage;
    String url ="https://timely-oxides.000webhostapp.com/AcsplitACprice.php";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_profile:
//                    mTextMessage.setText(R.string.title_Profile);
                    Intent I = new Intent( SplitAc.this, Profile.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Booking:
//                    mTextMessage.setText(R.string.title_MyBooking);
                    I = new Intent( SplitAc.this, Booking.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Help:
//                    mTextMessage.setText(R.string.title_HelpCenter);
                    Intent intent = new Intent( SplitAc.this, Help.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_logout:
//                    mTextMessage.setText(R.string.title_Logout);
                    intent = new Intent( SplitAc.this, Profile.class);
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
        setContentView(R.layout.activity_split);
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        txt_1=(TextView)findViewById(R.id.Rupees) ;
        txt_2=(TextView)findViewById(R.id.installRupees) ;
        txt_3=(TextView)findViewById(R.id.inunRupees) ;
        card_1= (androidx.cardview.widget.CardView)findViewById(R.id.cardview_1);
        card_2=(androidx.cardview.widget.CardView)findViewById(R.id.cardviewac);
        card_3=(androidx.cardview.widget.CardView)findViewById(R.id.cardviewinstall);
        card_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(SplitAc.this,SplitAc_repair_order.class);
                startActivity(I);
            }
        });
        card_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(SplitAc.this,Split_Ac_cleaning_order.class);
                startActivity(I);
            }
        });
        card_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(SplitAc.this,Split_Ac_install_Uninsstall.class);
                startActivity(I);
            }
        });
        loadPrice();
    }

    private void loadPrice() {


        StringRequest stringRequest = new StringRequest(
                url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  Log.d("TAG",response.toString());


                        try {

                            JSONArray jsonarray = new JSONArray(response);
                            for (int i = 0; i < jsonarray.length(); i++) {

                                JSONObject product=jsonarray.getJSONObject(i);
                                //JSONObject product = jsonarray.getJSONObject(i);

                                String AcCleaning = product.getString("AcCleaning");
                                String Repair = product.getString("Repair").trim();
                                String IntallPrice = product.getString("IntallPrice").trim();

                                txt_1.setText(AcCleaning);
                                txt_2.setText(IntallPrice);
                                txt_3.setText(Repair);

                            }
                        } catch(JSONException e){
                            e.printStackTrace();

                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error != null) {

                            Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        Volley.newRequestQueue(this).add(stringRequest);


    }
}
