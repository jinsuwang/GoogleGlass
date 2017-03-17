package com.samjin.DesignPattern.factorypattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjjin on 3/15/17.
 */
public class Pizza {

    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<String>();

    void prepare(){
        System.out.println("Preparing..." + name);
        System.out.println("Tossing dough..." );
        System.out.println("Adding sourcing...");
        System.out.println("Added toppings:");
        for( String topping : toppings ){
            System.out.println("    " + topping);
        }
    }

    void bake(){
        System.out.println("Bake for 25 min at 350F. ");
    }

    void cut(){
        System.out.println("Cutting Pizza");
    }
}
