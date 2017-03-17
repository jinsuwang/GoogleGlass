package com.samjin.DesignPattern.builderpattern;

/**
 * Created by sjjin on 3/5/17.
 */
public class Client {

    public static void main(String[] args) {

        ConcreteBuilder cBuilder = new ConcreteBuilder();
        Director director = new Director(cBuilder);
        director.construct();
    }
}
