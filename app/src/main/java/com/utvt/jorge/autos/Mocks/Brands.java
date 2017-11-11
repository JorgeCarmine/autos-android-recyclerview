package com.utvt.jorge.autos.Mocks;

import com.utvt.jorge.autos.Models.Brand;
import com.utvt.jorge.autos.Models.Car;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 11/11/17.
 */

public class Brands {

    private static AbstractList brands = new ArrayList<Brand>();

    public static ArrayList<Brand> configureInfo() {

        Brand brand;

        brand = new Brand("VW");
        brand.addCarr(new Car("Jetta", 230000));
        brand.addCarr(new Car("Golf", 238000));
        brand.addCarr(new Car("Gol", 160000));
        brands.add(brand);

        brand = new Brand("Chevrolet");
        brand.addCarr(new Car("Cheyenne", 400000));
        brand.addCarr(new Car("Suburban", 600000));
        brand.addCarr(new Car("Malibu", 390000));
        brands.add(brand);

        brand = new Brand("Nissan");
        brand.addCarr(new Car("Tsuru", 170000));
        brand.addCarr(new Car("HIOB", 238000));
        brand.addCarr(new Car("GTR", 160000));
        brands.add(brand);

        brand = new Brand("Honda");
        brand.addCarr(new Car("CIVIC", 230000));
        brand.addCarr(new Car("Accord", 238000));
        brands.add(brand);

        brand = new Brand("Ford");
        brand.addCarr(new Car("Fiesta", 230000));
        brand.addCarr(new Car("Lobo", 238000));
        brands.add(brand);
        return (ArrayList<Brand>) brands;
    }

}
