package com.example.uasmobileprogramming.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uasmobileprogramming.EditDosenActivity;
import com.example.uasmobileprogramming.EditMahasiswaActivity;
import com.example.uasmobileprogramming.Model.Dosen.Dosen;
import com.example.uasmobileprogramming.Model.Mahasiswa.Mahasiswa;
import com.example.uasmobileprogramming.R;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MyViewHolder>{
    List<Mahasiswa> mMahasiswaList;

    public MahasiswaAdapter(List <Mahasiswa> MahasiswaList) {
        mMahasiswaList = MahasiswaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("NIM : " + mMahasiswaList.get(position).getId());
        holder.mTextViewNama.setText("Nama Mahasiswa : " + mMahasiswaList.get(position).getNama());
        holder.mTextViewNomor.setText("No Telp : " + mMahasiswaList.get(position).getNomor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditMahasiswaActivity.class);

                mIntent.putExtra("Nim", mMahasiswaList.get(position).getId());
                mIntent.putExtra("Nama", mMahasiswaList.get(position).getNama());
                mIntent.putExtra("Nomor", mMahasiswaList.get(position).getNomor());

                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mMahasiswaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNomor;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvIdMahasiswa);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNamaMahasiswa);
            mTextViewNomor = (TextView) itemView.findViewById(R.id.tvNomorMahasiswa);
        }
    }
}