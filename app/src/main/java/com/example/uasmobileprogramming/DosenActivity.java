package com.example.uasmobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uasmobileprogramming.Adapter.DosenAdapter;
import com.example.uasmobileprogramming.Model.Dosen;
import com.example.uasmobileprogramming.Model.GetDosen;
import com.example.uasmobileprogramming.Rest.ApiClient;
import com.example.uasmobileprogramming.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenActivity extends AppCompatActivity {
    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static DosenActivity da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);

        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DosenActivity.this, InsertDosenActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        da = this;
        refresh();
    }

    public void refresh() {
        Call<GetDosen> dosenCall = mApiInterface.getDosen();
        dosenCall.enqueue(new Callback<GetDosen>() {
            @Override
            public void onResponse(Call<GetDosen> call, Response<GetDosen>
                    response) {
                List<Dosen> DosenList = response.body().getListDataDosen();
                System.out.println("tesssstatststs" + DosenList.toString());
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        DosenList.size());
                mAdapter = new DosenAdapter(DosenList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetDosen> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}