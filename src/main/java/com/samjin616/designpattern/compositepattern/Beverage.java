package com.samjin616.designpattern.compositepattern;

/**
 * Created by sjjin on 3/12/17.
 */
public abstract class Beverage {

    public String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }
    public abstract double cost();

}
