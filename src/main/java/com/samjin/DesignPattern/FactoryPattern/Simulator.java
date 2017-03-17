package com.samjin.DesignPattern.FactoryPattern;

/**
 * Created by sjjin on 3/17/17.
 */
public class Simulator {
    public static void main(String[] args) {

        PizzaStore nyStore = new NYPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Sam ordered a " + pizza.name);

        pizza = nyStore.createPizza("clam");
        System.out.println("Sam ordered a " + pizza.name);
    }
}
