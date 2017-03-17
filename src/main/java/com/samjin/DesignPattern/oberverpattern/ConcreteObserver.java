package com.samjin.DesignPattern.oberverpattern;

/**
 * Created by sjjin on 3/12/17.
 */
public class ConcreteObserver implements Observer{

    private String name;

    ConcreteObserver( String name ){
        this.name = name;
    }

    @Override
    public void upadte() {
        System.out.println(String.format("%s has been updated.", name));
    }
}
