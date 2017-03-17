package com.samjin.DesignPattern.strategypattern;

/**
 * Created by sjjin on 3/9/17.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quick() {
        System.out.println("Quack ... ");
    }
}
