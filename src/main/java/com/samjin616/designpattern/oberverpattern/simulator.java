package com.samjin616.designpattern.oberverpattern;

/**
 * Created by sjjin on 3/12/17.
 */
public class simulator {

    public static void main(String[] args) {
        Observer o1 = new ConcreteObserver("Sam");
        Observer o2 = new ConcreteObserver( "Wylie");
        Subject subject = new ConcreteSubject();

        subject.registerObserver(o1);
        subject.registerObserver(o2);
        subject.update();

        System.out.println("------------------");
        subject.removeObserver(o1);
        subject.update();

    }
}
