package com.example.shriramui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Changeprice_rowater extends AppCompatActivity {
    EditText FirstName, Mobileno ;

    // Creating button;
    Button InsertButton,btn_1;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String FirstNameHolder, MobileNoHolder ;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String server_url = "https://timely-oxides.000webhostapp.com/Rowater.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeprice_rowater);
        FirstName = (EditText) findViewById(R.id.editText);
        Mobileno = (EditText) findViewById(R.id.edit_3);
        btn_1=(Button)findViewById(R.id.Nextro);


        // Assigning ID's to Button.
        InsertButton = (Button) findViewById(R.id.buttonro);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(Changeprice_rowater.this);

        progressDialog = new ProgressDialog(Changeprice_rowater.this);

        // Adding click listener to button.
        InsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Showing progress dialog at user registration time.
                progressDialog.setMessage("Please Wait");
                progressDialog.show();

                // Calling method to get value from EditText.
                GetValueFromEditText();

                // Creating string request with post method.
                StringRequest stringRequest = new StringRequest(Request.Method.POST,server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(Changeprice_rowater.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(Changeprice_rowater.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {


                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("Repair", FirstNameHolder);
                        params.put("InstallationPrice", MobileNoHolder);


                        return params;
                    }

                };



                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(Changeprice_rowater.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);

            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Changeprice_rowater.this, RowaterInUn_InUn.class);
                startActivity(intent);
            }
        });

    }

    // Creating method to get value from EditText.
    public void GetValueFromEditText(){

        FirstNameHolder = FirstName.getText().toString().trim();
        MobileNoHolder = Mobileno.getText().toString().trim();

    }
}
