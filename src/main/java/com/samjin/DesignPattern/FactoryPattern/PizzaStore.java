package com.samjin.DesignPattern.FactoryPattern;

/**
 * Created by sjjin on 3/15/17.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.bake();
        pizza.cut();
        return pizza;
    }
    public abstract Pizza createPizza( String type );
}
