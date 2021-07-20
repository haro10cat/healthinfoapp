package com.hadi.healthinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.ViewHolder> {
    private ArrayList<Artikel> dataList;
    private Context context;
    private RecyclerViewClickListener listener;

    public ArtikelAdapter(ArrayList<Artikel> dataList, RecyclerViewClickListener listener) {
        this.dataList = dataList;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView Judul, Kategori, Tanggal;
        public ImageView Gambar;
        public CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            cardView = itemView.findViewById(R.id.view_design);
            Gambar = itemView.findViewById(R.id.image);
            Judul = itemView.findViewById(R.id.judul);
            Kategori = itemView.findViewById(R.id.kategori);
            Tanggal = itemView.findViewById(R.id.tanggal);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAbsoluteAdapterPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler, parent,false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final String Judul = dataList.get(position).getJudul();
        final String Kategori = dataList.get(position).getKategori();
        final String Tanggal = dataList.get(position).getTanggal();
        Artikel artikel = dataList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(artikel.getGambar())
                .apply(new RequestOptions().override(500, 750))
                .into(holder.Gambar);
        holder.Judul.setText(Judul);
        holder.Kategori.setText(Kategori);
        holder.Tanggal.setText(Tanggal);



    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    void setFilter(ArrayList<Artikel> filterList) {
        dataList = new ArrayList<>();
        dataList.addAll(filterList);
        notifyDataSetChanged();
    }
    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }



}
