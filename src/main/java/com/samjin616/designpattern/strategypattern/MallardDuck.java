package com.samjin616.designpattern.strategypattern;

/**
 * Created by sjjin on 3/9/17.
 */
public class MallardDuck extends Duck{
    MallardDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
}
