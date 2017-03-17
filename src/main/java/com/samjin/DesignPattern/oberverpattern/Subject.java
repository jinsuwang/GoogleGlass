package com.samjin.DesignPattern.oberverpattern;

/**
 * Created by sjjin on 3/10/17.
 */
public interface Subject {
    public void registerObserver( Observer observer );

    public void removeObserver( Observer observer );

    public void update();

}
