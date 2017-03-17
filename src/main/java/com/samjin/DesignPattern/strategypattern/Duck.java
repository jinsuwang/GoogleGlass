package com.samjin.DesignPattern.strategypattern;

/**
 * Created by sjjin on 3/9/17.
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){};

    public void performQuack(){
        quackBehavior.quick();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void setFlyBehavior( FlyBehavior flyBehavior ){
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior( QuackBehavior quackBehavior ){
        this.quackBehavior = quackBehavior;
    }
}
