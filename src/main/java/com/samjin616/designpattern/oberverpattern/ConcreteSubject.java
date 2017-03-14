package com.samjin616.designpattern.oberverpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjjin on 3/12/17.
 */
public class ConcreteSubject implements Subject {

    public List<Observer> obs;

    public ConcreteSubject(){
        obs = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        obs.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        obs.remove(observer);
    }

    @Override
    public void update() {
        for( Observer o : obs ){
            o.upadte();
        }
    }
}
