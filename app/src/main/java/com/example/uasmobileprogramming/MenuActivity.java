package com.example.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity implements View.OnClickListener {
    SharedPreference SharedPreferences;
    Activity context = this;
    TextView Username;
    String UsernameValue;
    CardView CardView, CardView2, CardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        SharedPreferences = new SharedPreference();
        Username          = findViewById(R.id.UsernameMenu);

        UsernameValue = SharedPreferences.getValue(context, "username");
        Username.setText("Selamat Datang, " + UsernameValue + " ! ");

        CardView           = findViewById(R.id.Menu1);
        CardView.setOnClickListener(this);
        CardView2          = findViewById(R.id.Menu2);
        CardView2.setOnClickListener(this);
        CardView3          = findViewById(R.id.Menu3);
        CardView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        System.out.println("TEST");
        switch (v.getId()) {
            case R.id.Menu1:
                startActivity(new Intent(MenuActivity.this, DosenActivity.class));
                break;
            case R.id.Menu3:
                startActivity(new Intent(MenuActivity.this, ProfilActivity.class));
                break;
        }
        finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
