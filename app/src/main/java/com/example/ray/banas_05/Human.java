package com.example.ray.banas_05;

import java.io.Serializable;

/**
 * Created by ray on 13.06.2015.
 */
public class Human implements Serializable {
    private String  name;
    private double  height;
    private double  weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Human(String name, double height, double weight) {

        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}
