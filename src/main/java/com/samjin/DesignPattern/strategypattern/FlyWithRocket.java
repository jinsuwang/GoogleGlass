package com.samjin.DesignPattern.strategypattern;

/**
 * Created by sjjin on 3/9/17.
 */
public class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I am flying with rocket.");
    }
}
