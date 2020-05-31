package com.example.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    SharedPreference SharedPreferences;
    Activity context = this;
    TextView Username;
    String UsernameValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Username      = findViewById(R.id.UsernameMenu);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        SharedPreferences = new SharedPreference();
        UsernameValue = SharedPreferences.getValue(context, "Username");
        Username.setText("Selamat Datang, " + UsernameValue + " ! ");
    }
}
