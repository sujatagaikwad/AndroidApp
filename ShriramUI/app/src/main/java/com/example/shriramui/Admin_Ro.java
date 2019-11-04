package com.example.shriramui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

public class Admin_Ro extends AppCompatActivity {
    private ImageView img;
    TextView txt_1,txt_3,txt_2;
    CardView cardadminro_1,cardadminro_2,cardadminro_3;
    private TextView mTextMessage;
    String url = "https://timely-oxides.000webhostapp.com/RowaterInunfetch.php";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent I = new Intent( Admin_Ro.this, Home.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_profile:
//                    mTextMessage.setText(R.string.title_Profile);
                    I = new Intent( Admin_Ro.this, Profile.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Booking:
//                    mTextMessage.setText(R.string.title_MyBooking);
                    I = new Intent( Admin_Ro.this, Booking.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Help:
//                    mTextMessage.setText(R.string.title_HelpCenter);
                    Intent intent = new Intent( Admin_Ro.this, Help.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_logout:
//                    mTextMessage.setText(R.string.title_Logout);
                    intent = new Intent( Admin_Ro.this, Profile.class);
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
        setContentView(R.layout.activity_admin__ro);
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        txt_1=(TextView)findViewById(R.id.Installprice);
        txt_2=(TextView)findViewById(R.id.uninstallprice);
        txt_3=(TextView)findViewById(R.id.InUnPrice);

        cardadminro_1= (CardView) findViewById(R.id.cardro);
        cardadminro_2= (CardView) findViewById(R.id.card_2);
        cardadminro_3= (CardView) findViewById(R.id.card_3);
        cardadminro_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(Admin_Ro.this, Rowater_install.class);
                startActivity(I);

            }
        });
        cardadminro_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(Admin_Ro.this, Rowater_unistall_order.class);
                startActivity(I);

            }
        });
        cardadminro_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(Admin_Ro.this, Rowater_inst_Un_install.class);
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

                                String Install = product.getString("Install");
                                String Uninstall = product.getString("Uninstall").trim();
                                String Install_Uninstall = product.getString("Install_Uninstall").trim();

                                txt_1.setText(Install);
                                txt_2.setText(Uninstall);
                                txt_3.setText(Install_Uninstall);


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
