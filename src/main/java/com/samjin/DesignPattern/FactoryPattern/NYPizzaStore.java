package com.samjin.DesignPattern.FactoryPattern;

/**
 * Created by sjjin on 3/17/17.
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String item) {
        if(item.equals("cheese")){
            return new NYStyleCheesePizza();
        } else if (item.endsWith("clam")){
            return new NYStyleClamPizza();
        }
        return null;
    }
}
