package com.utvt.jorge.autos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.utvt.jorge.autos.Models.Brand;
import com.utvt.jorge.autos.Models.Car;

import java.util.List;

/**
 * Created by jorge on 10/11/17.
 */

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder> {

    private List<Brand> brands;
    private int layout;
    private OnItemClickListener itemClickListener;

    public BrandAdapter(List<Brand> brands, int layout, OnItemClickListener listener) {
        this.brands = brands;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(brands.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return brands.size();
    }

    public interface OnItemClickListener {
        void onItemClick(String name, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewname;

        public ViewHolder(View view) {
            super(view);
            this.textViewname = (TextView) view.findViewById(R.id.textViewName);
        }

        public void bind(final Brand brand, final OnItemClickListener listener) {
            this.textViewname.setText(brand.name);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    listener.onItemClick(brand.name, getAdapterPosition());
                }
            });
        }
    }

}
