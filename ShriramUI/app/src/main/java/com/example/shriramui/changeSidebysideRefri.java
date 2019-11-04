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

public class changeSidebysideRefri extends AppCompatActivity {
    EditText FirstName ;

    // Creating button;
    Button InsertButton,btn_1;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String FirstNameHolder ;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String server_url = "https://timely-oxides.000webhostapp.com/changePricesidbysideRefri.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_sidebyside_refri);
        btn_1=(Button)findViewById(R.id.Backid) ;
        FirstName = (EditText) findViewById(R.id.Rupees);
        InsertButton = (Button) findViewById(R.id.Addbutton);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(changeSidebysideRefri.this);

        progressDialog = new ProgressDialog(changeSidebysideRefri.this);

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
                                Toast.makeText(changeSidebysideRefri.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(changeSidebysideRefri.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {


                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("Repair", FirstNameHolder);


                        return params;
                    }

                };



                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(changeSidebysideRefri.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);

            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(changeSidebysideRefri.this,Customer_list.class);
                startActivity(I);
            }
        });


    }

    // Creating method to get value from EditText.
    public void GetValueFromEditText(){

        FirstNameHolder = FirstName.getText().toString().trim();

    }
}
