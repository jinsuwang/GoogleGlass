package com.samjin.DesignPattern.strategypattern;

/**
 * Created by sjjin on 3/9/17.
 */
public class DuckSimulator {
    public static void main(String[] args) {
        Duck malllard = new MallardDuck();

        malllard.performQuack();
        malllard.performFly();

        FlyBehavior flyWithRocket = new FlyWithRocket();
        malllard.setFlyBehavior(flyWithRocket);


        malllard.performQuack();
        malllard.performFly();
    }
}