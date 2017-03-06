package com.samjin616.designpattern.builderpattern;

/**
 * Created by sjjin on 3/5/17.
 */
public class Product {
    // 产品部件A
    private String partA;
    // 产品部件B
    private String partB;
    // 产品部件C
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

}