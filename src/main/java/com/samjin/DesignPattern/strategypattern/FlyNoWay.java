package com.samjin.DesignPattern.strategypattern;

/**
 * Created by sjjin on 3/9/17.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can not fly...");
    }
}
