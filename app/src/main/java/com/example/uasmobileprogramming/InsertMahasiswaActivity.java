package com.example.uasmobileprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uasmobileprogramming.Model.Dosen.PostPutDelDosen;
import com.example.uasmobileprogramming.Model.Mahasiswa.PostPutDelMahasiswa;
import com.example.uasmobileprogramming.Rest.ApiClient;
import com.example.uasmobileprogramming.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertMahasiswaActivity extends AppCompatActivity {
    EditText edtNama, edtNomor, edtNIM;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_mahasiswa_activty);
        edtNIM = (EditText) findViewById(R.id.edtNimMahasiwa);
        edtNama = (EditText) findViewById(R.id.edtNamaMahasiwa);
        edtNomor = (EditText) findViewById(R.id.edtNomorMahasiswa);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInsertingMahasiswa);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMahasiswa> postMahasiswaCall = mApiInterface.postMahasiswa(edtNIM.getText().toString(), edtNama.getText().toString(), edtNomor.getText().toString());
                postMahasiswaCall.enqueue(new Callback<PostPutDelMahasiswa>() {
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