package com.example.mvignetteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<TextView> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles.add((TextView) findViewById(R.id.fleetName1));
        titles.add((TextView) findViewById(R.id.fleetName2));
        titles.add((TextView) findViewById(R.id.fleetName3));
        titles.add((TextView) findViewById(R.id.fleetName4));

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://mvignette.azurewebsites.net/api/v1/Fleet?userName=bob";
        JsonArrayRequest request = new JsonArrayRequest(url, jsonArrayListener, errorListener);
        requestQueue.add(request);
    }

    private final Response.Listener<JSONArray> jsonArrayListener = response -> {
        for (int i = 0; i < response.length(); i++){
            try {
                JSONObject object =response.getJSONObject(i);
                String name = object.getString("name");

                titles.get(i).setText(name);

            } catch (JSONException e){
                e.printStackTrace();
                return;

            }
        }
    };

    private final Response.ErrorListener errorListener = error -> Log.d("REST error", error.getMessage());
}