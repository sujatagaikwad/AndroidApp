package com.example.shriramui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Admin_washing extends AppCompatActivity {
    private ImageView img;
    TextView txt_1,txt_3,txt_4,editText;
    TextView edt_1,edt_2;
    CardView cardmicroview_1,cardmicroview_2;
    private TextView mTextMessage;
    String url = "https://timely-oxides.000webhostapp.com/washing_machine.php";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent I = new Intent( Admin_washing.this, Home.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_profile:
//                    mTextMessage.setText(R.string.title_Profile);
                    I = new Intent( Admin_washing.this, Profile.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Booking:
//                    mTextMessage.setText(R.string.title_MyBooking);
                    I = new Intent( Admin_washing.this, Booking.class);
                    startActivity(I);
                    return true;
                case R.id.navigation_Help:
//                    mTextMessage.setText(R.string.title_HelpCenter);
                    Intent intent = new Intent( Admin_washing.this, Help.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_logout:
//                    mTextMessage.setText(R.string.title_Logout);
                    intent = new Intent( Admin_washing.this, Profile.class);
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
        setContentView(R.layout.activity_admin_washing);
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        txt_1 = (TextView) findViewById(R.id.textwashing);
        txt_3 = (TextView) findViewById(R.id.Repair);
        txt_4 = (TextView) findViewById(R.id.textinstall);
        edt_1 = (TextView) findViewById(R.id.installRupees);
        editText = (TextView) findViewById(R.id.editwashing);
        edt_2 = (TextView) findViewById(R.id.Rupees);
        cardmicroview_1 = (CardView) findViewById(R.id.cardmicrowave);
        cardmicroview_2 = (CardView) findViewById(R.id.cardmicro);

        cardmicroview_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(Admin_washing.this, WashingNotSure.class);
                startActivity(I);
            }
        });
        cardmicroview_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(Admin_washing.this, Washingnotsure_order.class);
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

                                String Repair = product.getString("Repair");
                                String Installationprice = product.getString("Installationprice").trim();

                                edt_2.setText(Repair);
                                edt_1.setText(Installationprice);

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
