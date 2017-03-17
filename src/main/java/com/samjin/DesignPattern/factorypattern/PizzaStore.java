package com.samjin.DesignPattern.factorypattern;

/**
 * Created by sjjin on 3/15/17.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.bake();
        return pizza;
    }
    public abstract Pizza createPizza( String type );
}
