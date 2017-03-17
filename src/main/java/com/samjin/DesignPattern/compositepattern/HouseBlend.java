package com.samjin.DesignPattern.compositepattern;

/**
 * Created by sjjin on 3/13/17.
 */
public class HouseBlend extends Beverage {

    public HouseBlend(){
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
