/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sam
 */
public class ZigzagIterator {

    int i;
    List<Iterator<Integer>> list = new ArrayList<Iterator<Integer>>();;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list.add(v1.iterator());
        list.add(v2.iterator());
        i = 0;
    }

    public int next() {
        if( hasNext()){
            int val = list.get(i).next();
            i = ( i + 1 ) % list.size();
            return val;
        }else{
            return 0;
        }
    }

    public boolean hasNext(){
        while( !list.isEmpty() && !list.get(i).hasNext() ){
            list.remove(i);
            if( i == list.size() ){
                i = 0;
            }
        }
        return !list.isEmpty();
    }
}
