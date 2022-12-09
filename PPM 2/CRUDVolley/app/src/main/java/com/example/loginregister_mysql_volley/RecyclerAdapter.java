package com.example.loginregister_mysql_volley;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<Data> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Data> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.id.setText(arrayList.get(position).getId());
        holder.namaBarang.setText(arrayList.get(position).getNamaBarang());
        holder.hargaBarang.setText(arrayList.get(position).getHargaBarang());
        holder.supplier.setText(arrayList.get(position).getSupplier());

    }

    @Override
    public int getItemCount() {
        return  arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id, namaBarang, hargaBarang, supplier;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.txt_id);
            namaBarang = (TextView) itemView.findViewById(R.id.txt_namaBarang);
            hargaBarang = (TextView) itemView.findViewById(R.id.txt_hargaBarang);
            supplier = (TextView) itemView.findViewById(R.id.txt_supplier);
        }
    }
}
