package com.utvt.jorge.autos.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 10/11/17.
 */

public class Brand {

    public String name;

    public List<Car> cars = new ArrayList<Car>();

    public Brand(String name) {
        this.name = name;
    }

    public void addCarr(Car car) {
        this.cars.add(car);
    }

}
