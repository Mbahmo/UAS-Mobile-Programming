package com.example.uasmobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uasmobileprogramming.Model.Dosen.PostPutDelDosen;
import com.example.uasmobileprogramming.Rest.ApiClient;
import com.example.uasmobileprogramming.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditDosenActivity extends AppCompatActivity {
    EditText edtId, edtNama, edtNomor;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dosen);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtNomor = (EditText) findViewById(R.id.edtNomor);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edtNomor.setText(mIntent.getStringExtra("Nomor"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelDosen> updateDosenCall = mApiInterface.putDosen(
                        edtId.getText().toString(),
                        edtNama.getText().toString(),
                        edtNomor.getText().toString());
                updateDosenCall.enqueue(new Callback<PostPutDelDosen>() {
                    @Override
                    public void onResponse(Call<PostPutDelDosen> call, Response<PostPutDelDosen> response) {
                        DosenActivity.da.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelDosen> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelDosen> deleteDosen = mApiInterface.deleteDosen(edtId.getText().toString());
                    deleteDosen.enqueue(new Callback<PostPutDelDosen>() {
                        @Override
                        public void onResponse(Call<PostPutDelDosen> call, Response<PostPutDelDosen> response) {
                            DosenActivity.da.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelDosen> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DosenActivity.da.refresh();
                finish();
            }
        });
    }
}