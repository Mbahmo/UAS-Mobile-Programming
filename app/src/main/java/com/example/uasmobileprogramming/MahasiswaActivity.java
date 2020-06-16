package com.example.uasmobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uasmobileprogramming.Adapter.DosenAdapter;
import com.example.uasmobileprogramming.Adapter.MahasiswaAdapter;
import com.example.uasmobileprogramming.Model.Dosen.Dosen;
import com.example.uasmobileprogramming.Model.Dosen.GetDosen;
import com.example.uasmobileprogramming.Model.Mahasiswa.GetMahasiswa;
import com.example.uasmobileprogramming.Model.Mahasiswa.Mahasiswa;
import com.example.uasmobileprogramming.Rest.ApiClient;
import com.example.uasmobileprogramming.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaActivity extends AppCompatActivity {
    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MahasiswaActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        btIns = (Button) findViewById(R.id.btInsMahasiswa);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MahasiswaActivity.this, InsertDosenActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewMahasiswa);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
        refresh();
    }

    public void refresh() {
        Call<GetMahasiswa> mahasiswaCall = mApiInterface.getMahasiswa();
        mahasiswaCall.enqueue(new Callback<GetMahasiswa>() {
            @Override
            public void onResponse(Call<GetMahasiswa> call, Response<GetMahasiswa>
                    response) {
                List<Mahasiswa> MahasiswaList = response.body().getListDataMahasiswa();
                Log.d("Retrofit Get", "Jumlah data Mahasiswa: " +
                        MahasiswaList.size());
                mAdapter = new MahasiswaAdapter(MahasiswaList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetMahasiswa> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}