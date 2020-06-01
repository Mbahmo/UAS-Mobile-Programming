package com.example.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    SharedPreference SharedPreferences;
    Activity context = this;
    TextView Username;
    String UsernameValue;
    CardView CardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        SharedPreferences = new SharedPreference();
        Username          = findViewById(R.id.UsernameMenu);
        CardView          = findViewById(R.id.Menu1);

        UsernameValue = SharedPreferences.getValue(context, "username");
        Username.setText("Selamat Datang, " + UsernameValue + " ! ");

        CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "KONTOL", Toast.LENGTH_LONG).show();
            }
        });
    }
}
