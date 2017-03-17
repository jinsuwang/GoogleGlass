package com.samjin.DesignPattern.builderpattern;

/**
 * Created by sjjin on 3/5/17.
 */
public abstract class Builder {
    protected Product product = new Product();

    protected abstract void buildPartA();

    protected abstract void buildPartB();

    protected abstract void buildPartC();

    public Product getProduct(){
        return product;
    }

}