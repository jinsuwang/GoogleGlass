package com.samjin.DesignPattern.compositepattern;

/**
 * Created by sjjin on 3/13/17.
 */
public class Espresso extends Beverage{

    public Espresso(){
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
