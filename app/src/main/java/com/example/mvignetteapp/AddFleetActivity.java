package com.example.mvignetteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AddFleetActivity extends AppCompatActivity {

    private TextView status;
    private EditText name;
    private EditText surname;
    private EditText date;

    private RequestQueue requestQueue;
    private String url = "https://mvignette.azurewebsites.net/api/v1/Fleet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fleet);
    }
}