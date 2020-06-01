package com.example.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText TxtUsername, TxtPassword;
    Button BtnLogin;
    SharedPreference SharedPreferences;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences = new SharedPreference();
        TxtUsername      = findViewById(R.id.TxtUsername);
        TxtPassword      = findViewById(R.id.TxtPassword);
        BtnLogin         = findViewById(R.id.ButtonLogin);

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = TxtUsername.getText().toString();

                if(Username.equals("")) {
                    Toast.makeText(getBaseContext(), "Username Masih Kosong !", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences.save(context, "username", Username);
                    System.out.println("Test" + SharedPreferences.getValue(context, "username"));
                    Intent Intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(Intent);
                    Toast.makeText(getBaseContext(), "Berhasil Login !", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
