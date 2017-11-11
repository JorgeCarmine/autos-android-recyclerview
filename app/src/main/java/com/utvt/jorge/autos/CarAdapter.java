package com.utvt.jorge.autos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utvt.jorge.autos.Models.Car;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jorge on 10/11/17.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private List<Car> cars;
    private int layout;
    private CarAdapter.OnItemClickListener itemClickListener;

    public CarAdapter(List<Car> cars, int layout, CarAdapter.OnItemClickListener listener) {
        this.cars = cars;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        CarAdapter.ViewHolder vh = new CarAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(CarAdapter.ViewHolder holder, int position) {
        holder.bind(cars.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public interface OnItemClickListener {
        void onItemClick(String name, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;

        public ViewHolder(View view) {
            super(view);
            this.textViewName = (TextView) view.findViewById(R.id.textViewName);
        }

        public void bind(final Car car, final CarAdapter.OnItemClickListener listener) {
            this.textViewName.setText(car.name);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    listener.onItemClick(car.name, getAdapterPosition());
                }
            });
        }
    }
}

