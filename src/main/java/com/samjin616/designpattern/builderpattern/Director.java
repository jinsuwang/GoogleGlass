package com.samjin616.designpattern.builderpattern;

/**
 * Created by sjjin on 3/5/17.
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }


    public Product construct() {
        System.out.println("--- 指挥者开始 构建产品 ---");
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        System.out.println("--- 指挥者 构建产品 完成 ---");
        return builder.getProduct();
    }
}
