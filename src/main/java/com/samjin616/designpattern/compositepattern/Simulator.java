package com.samjin616.designpattern.compositepattern;

/**
 * Created by sjjin on 3/13/17.
 */
public class Simulator {
    public static void main(String[] args) {
        Beverage b1 = new Espresso();
        System.out.println( b1.getDescription() + " " + b1.cost()  );

        Beverage b2 = new Mocha(b1);
        System.out.println( b2.getDescription() + " " + b2.cost() );
    }
}
