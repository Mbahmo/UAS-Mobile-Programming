package com.example.uasmobileprogramming.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uasmobileprogramming.EditDosenActivity;
import com.example.uasmobileprogramming.Model.Dosen;
import com.example.uasmobileprogramming.R;

import java.util.List;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.MyViewHolder>{
    List<Dosen> mDosenList;

    public DosenAdapter(List <Dosen> DosenList) {
        mDosenList = DosenList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dosen_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("Id = " + mDosenList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mDosenList.get(position).getNama());
        holder.mTextViewNomor.setText("Nomor = " + mDosenList.get(position).getNomor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditDosenActivity.class);

                mIntent.putExtra("Id", mDosenList.get(position).getId());
                mIntent.putExtra("Nama", mDosenList.get(position).getNama());
                mIntent.putExtra("Nomor", mDosenList.get(position).getNomor());

                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mDosenList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNomor;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewNomor = (TextView) itemView.findViewById(R.id.tvNomor);
        }
    }
}