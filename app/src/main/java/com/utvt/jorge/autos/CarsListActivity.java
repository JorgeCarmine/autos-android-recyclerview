package com.utvt.jorge.autos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.utvt.jorge.autos.Mocks.Brands;
import com.utvt.jorge.autos.Models.Brand;
import com.utvt.jorge.autos.Models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsListActivity extends AppCompatActivity {

    public TextView textViewTitle;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Brand> brands = new ArrayList<Brand>();
    private Brand brand;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }

        this.textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        this.brands = Brands.configureInfo();
        int position = (int) getIntent().getIntExtra("idBrand", 0);
        brand = brands.get(position);

        this.textViewTitle.setText("Lista de autos " + brand.name);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        adapter = new CarAdapter(this.brand.cars, R.layout.car_item, new CarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                String price = Integer.toString(brand.cars.get(position).price);
                showAlertDialog(name, "El precio de " + name + " es de: \n$ " + price + ".00");
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void showAlertDialog(String title, String message){
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
