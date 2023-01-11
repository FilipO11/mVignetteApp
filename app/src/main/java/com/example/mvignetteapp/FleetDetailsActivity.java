package com.example.mvignetteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FleetDetailsActivity extends AppCompatActivity {
    ArrayList<TextView> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet_details);

        titles.add((TextView) findViewById(R.id.vehicleName1));
        titles.add((TextView) findViewById(R.id.vehicleName2));
        titles.add((TextView) findViewById(R.id.vehicleName3));
        titles.add((TextView) findViewById(R.id.vehicleName4));

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://mvignette.azurewebsites.net/api/v1/Fleet/1";
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