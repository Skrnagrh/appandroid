package com.example.quis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterProcess extends RecyclerView.Adapter<AdapterProcess.ViewProcessHolder> {

    Context context;
    private ArrayList<ModelData> item; //memanggil modelData

    public AdapterProcess(Context context, ArrayList<ModelData> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public ViewProcessHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false); //memanggil layout list recyclerview
        ViewProcessHolder processHolder = new ViewProcessHolder(view);
        return processHolder;
    }


    @Override
    public void onBindViewHolder(ViewProcessHolder holder, int position) {

        final ModelData data = item.get(position);
        final int panjang = data.getNamacust().length();
        if (panjang >= 50){
            final String mIsi = data.getNamacust().substring(0,50);
            holder.txtNamaCust.setText(mIsi.concat("..."));
        } else {
            final String mIsi = data.getNamacust();
            holder.txtNamaCust.setText(mIsi);
        }
        holder.txtKodeCust.setText(data.getKodecust());
        holder.txtKota.setText(data.getKota());
        holder.txtNohp.setText(data.getNoHp());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewProcessHolder extends RecyclerView.ViewHolder {

        TextView txtNamaCust;
        TextView txtKodeCust;
        TextView txtKota;
        TextView txtNohp;

        public ViewProcessHolder(View itemView) {
            super(itemView);

            txtNamaCust = itemView.findViewById(R.id.txtNamaCust);
            txtKodeCust = itemView.findViewById(R.id.txtKodeCust);
            txtKota = itemView.findViewById(R.id.txtKota);
            txtNohp = itemView.findViewById(R.id.txtNohp);

        }
    }
}
