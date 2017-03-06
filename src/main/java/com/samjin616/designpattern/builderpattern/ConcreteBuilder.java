package com.samjin616.designpattern.builderpattern;

/**
 * Created by sjjin on 3/5/17.
 */
public class ConcreteBuilder extends Builder {

    @Override
    protected void buildPartA() {
        product.setPartA("build Part A");
        System.out.println("正在建造产品部件A");
    }

    @Override
    protected void buildPartB() {
        product.setPartB("build Part B");
        System.out.println("正在建造产品部件B");
    }

    @Override
    protected void buildPartC() {
        product.setPartC("build Part C");
        System.out.println("正在建造产品部件C");
    }

}