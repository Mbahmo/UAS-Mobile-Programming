package com.example.uasmobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uasmobileprogramming.Model.Mahasiswa.PostPutDelMahasiswa;
import com.example.uasmobileprogramming.Rest.ApiClient;
import com.example.uasmobileprogramming.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditMahasiswaActivity extends AppCompatActivity {
    EditText edtId, edtNama, edtNomor;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;
    String NimLama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mahasiswa);
        edtId = (EditText) findViewById(R.id.edtIdMahasiswa);
        edtNama = (EditText) findViewById(R.id.edtNamaMahasiwa);
        edtNomor = (EditText) findViewById(R.id.edtNomorMahasiswa);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Nim"));
        NimLama = edtId.getText().toString();
//        edtId.setTag(edtId.getKeyListener());
//        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edtNomor.setText(mIntent.getStringExtra("Nomor"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2Mahasiswa);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMahasiswa> updateMahasiswaCall = mApiInterface.putMahasiswa(
                        NimLama,
                        edtId.getText().toString(),
                        edtNama.getText().toString(),
                        edtNomor.getText().toString());
                updateMahasiswaCall.enqueue(new Callback<PostPutDelMahasiswa>() {
                    @Override
                    public void onResponse(Call<PostPutDelMahasiswa> call, Response<PostPutDelMahasiswa> response) {
                        MahasiswaActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelMahasiswa> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btDelete = (Button) findViewById(R.id.btDelete2Mahasiswa);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelMahasiswa> deleteMahasiswa = mApiInterface.deleteMahasiswa(edtId.getText().toString());
                    deleteMahasiswa.enqueue(new Callback<PostPutDelMahasiswa>() {
                        @Override
                        public void onResponse(Call<PostPutDelMahasiswa> call, Response<PostPutDelMahasiswa> response) {
                            MahasiswaActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelMahasiswa> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        btBack = (Button) findViewById(R.id.btBackGoMahasiswa);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MahasiswaActivity.ma.refresh();
                finish();
            }
        });
    }
}