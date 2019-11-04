package com.example.shriramui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RowaterRepair_order extends AppCompatActivity {
    CardView cardadminro_1,cardadminro_2;
    TextView edt_1,edt_2;
    String url ="https://timely-oxides.000webhostapp.com/RowaterPricestore.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rowater_repair_order);
        cardadminro_1= (CardView) findViewById(R.id.cardmicrowave);
        cardadminro_2= (CardView) findViewById(R.id.cardmicro);
        edt_2 = (TextView) findViewById(R.id.installRupees);
        edt_1 = (TextView) findViewById(R.id.Rupees);

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
                                String InstallationPrice = product.getString("InstallationPrice").trim();

                                edt_1.setText(Repair);
                                edt_2.setText(InstallationPrice);

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

        cardadminro_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(RowaterRepair_order.this, Rowater_Repair_service.class);
                startActivity(I);



            }
        });
        cardadminro_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(RowaterRepair_order.this, Rowater_service_filter.class);
                startActivity(I);

            }
        });

    }
}
