package com.example.shriramui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
    Button login;
    EditText username, password;
    Spinner spinnerloginas;
    String userrole;
    private String[] userRoleString = new String[]{"admin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        login = (Button) findViewById(R.id.buttonlogin);
        username = (EditText) findViewById(R.id.editTextusername);
        password = (EditText) findViewById(R.id.editTextpassword);
        spinnerloginas = (Spinner) findViewById(R.id.spinnerloginas);
        spinnerloginas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
//                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                userrole = (String) spinnerloginas.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, userRoleString);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerloginas.setAdapter(adapter_role);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (userrole.equals("admin")) {

                    String user_name = username.getText().toString();
                    String pass_word = password.getText().toString();

                    if (TextUtils.isEmpty(user_name)) {
                        username.setError("Invalid User Name");
                    } else if (TextUtils.isEmpty(pass_word)) {
                        password.setError("enter password");
                    } else {
                        if (user_name.equals("admin") & pass_word.equals("admin123")) {
                            Intent intent = new Intent(Admin.this, Customer_list.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


            }

        });
    }
}
