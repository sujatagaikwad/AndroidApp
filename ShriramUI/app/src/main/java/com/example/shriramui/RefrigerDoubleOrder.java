package com.example.shriramui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RefrigerDoubleOrder extends AppCompatActivity {
    RadioGroup group;
    RadioButton btn_1,btn_2;
    Button btn_3;
    TextView edt_1,edt_3;
    EditText editText_1,editText_2,editText_3;
    String server_url="https://timely-oxides.000webhostapp.com/info.php";
    String url = "https://timely-oxides.000webhostapp.com/RefrigeratormachineDouble.php";
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refriger_double_order);
        edt_1=(TextView)findViewById(R.id.reapirp) ;
        edt_3=(TextView)findViewById(R.id.checkedTextView);
        editText_1=(EditText)findViewById(R.id.editname);
        editText_2=(EditText)findViewById(R.id.editaddress);
        editText_3=(EditText)findViewById(R.id.editmobole);
        group=(RadioGroup)findViewById(R.id.radiogp);
        builder= new AlertDialog.Builder(RefrigerDoubleOrder.this);
        btn_3=(Button)findViewById(R.id.btn_confirm);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String washingtextview,Repairprice,name,address,mobileno;
                washingtextview = edt_3.getText().toString();
                Repairprice=edt_1.getText().toString();
                name=editText_1.getText().toString();
                address=editText_2.getText().toString();
                mobileno=editText_3.getText().toString();
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
                                        edt_3.setText("Refrigerator Machine Double_Type");
                                        editText_1.setText("");
                                        editText_2.setText("");
                                        editText_3.setText("");

                                    }
                                });
                                AlertDialog alertDialog =builder.create();
                                alertDialog.show();

                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RefrigerDoubleOrder.this,"Error.....",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String>params = new HashMap<String, String>();
                        params.put("name",name);
                        params.put("address",address);
                        params.put("mobileno",mobileno);
                        params.put("washingtextview",washingtextview);
                        params.put("Repairprice",Repairprice);


                        return params;
                    }
                };
                MySingleton.getInstance(RefrigerDoubleOrder.this).addTorequestque(stringRequest);
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
                                // String Installationprice = product.getString("Installationprice").trim();

                                edt_1.setText(Repair);


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
    public void radiomr(View view){
        int btn_1select=group.getCheckedRadioButtonId();
        btn_1=(RadioButton)findViewById(R.id.radiomr_1);
        Toast.makeText(RefrigerDoubleOrder.this,btn_1.getText(),Toast.LENGTH_LONG).show();
    }
    public void radiomiss(View view){
        int btn_2select=group.getCheckedRadioButtonId();
        btn_2=(RadioButton)findViewById(R.id.radiomiss_1);
        Toast.makeText(RefrigerDoubleOrder.this,btn_2.getText(),Toast.LENGTH_LONG).show();

    }
}
