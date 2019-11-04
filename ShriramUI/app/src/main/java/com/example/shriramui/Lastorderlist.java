package com.example.shriramui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Lastorderlist extends Activity {
    String JSON_STRING;
    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastorderlist);
    }
    public void getJSON(View view)
    {
        new Lastorderlist.BackgroundTask().execute();
    }
    class BackgroundTask extends AsyncTask<Void,Void,String>{
        String json_url;
        @Override
        protected void onPreExecute() {
            json_url="https://timely-oxides.000webhostapp.com/finalOrder.php";
        }


        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine())!= null) {
                    stringBuilder.append(JSON_STRING + "\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView=(TextView) findViewById(R.id.textView);
            textView.setText(result);
            json_string=result;
        }
    }
    public void parseJSON(View view)
    {
        if (json_string==null){
            Toast.makeText(getApplicationContext(),"First Get JSON",Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, DisplayLastOrder.class);
            intent.putExtra("json_data", json_string);
            startActivity(intent);
        }
    }
}







