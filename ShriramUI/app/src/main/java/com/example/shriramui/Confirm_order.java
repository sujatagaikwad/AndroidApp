package com.example.shriramui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Confirm_order extends AppCompatActivity {
     EditText edt_1,edt_2,edt_3,edt_4,edt_5;
    Button btn_1;
String server_url="https://timely-oxides.000webhostapp.com/order.php";
     AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        edt_1=(EditText)findViewById(R.id.name);
        edt_2=(EditText)findViewById(R.id.address);
        edt_3=(EditText)findViewById(R.id.city);
        edt_4=(EditText)findViewById(R.id.mobileno);
        edt_5=(EditText)findViewById(R.id.requirement);
        builder= new AlertDialog.Builder(Confirm_order.this);
        btn_1=(Button)findViewById(R.id.btn_confirm);
       btn_1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String name,address,city,mobileno,requirement;
               name = edt_1.getText().toString();
               address=edt_2.getText().toString();
               city=edt_3.getText().toString();
               mobileno=edt_4.getText().toString();
               requirement=edt_5.getText().toString();
               StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                       new Response.Listener<String>() {
                           @Override
                           public void onResponse(String response) {
                               builder.setTitle("Server Response");
                               builder.setMessage("Response :"+response);
                               builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {
                                   edt_1.setText("");
                                       edt_2.setText("");
                                       edt_3.setText("");
                                       edt_4.setText("");
                                       edt_5.setText("");

                                   }
                               });
                               AlertDialog alertDialog =builder.create();
                               alertDialog.show();

                           }
                       }
                       , new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                       Toast.makeText(Confirm_order.this,"Error.....",Toast.LENGTH_SHORT).show();
                       error.printStackTrace();

                   }
               }){
                   @Override
                   protected Map<String, String> getParams() throws AuthFailureError {
                       Map<String,String>params = new HashMap<String, String>();
                       params.put("name",name);
                       params.put("city",city);
                               params.put("address",address);
                                       params.put("mobileno",mobileno);
                                               params.put("requirement",requirement);
                       return params;
                   }
               };
               MySingleton.getInstance(Confirm_order.this).addTorequestque(stringRequest);
           }
       });
    }



}
