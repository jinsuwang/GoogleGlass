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
public class Vector2D  implements Iterator<Integer>{
    
    private List<Iterator<Integer>> it;  
    
    public Vector2D(List<List<Integer>> vec2d) {
        it = new ArrayList<Iterator<Integer>>();
        for( List<Integer> e : vec2d ){
            if( !e.isEmpty() ) it.add( e.iterator() );
        }
    }

    @Override
    public Integer next() {
        if( !hasNext() ) return 0;
        int sol = it.get(0).next();
        if( !it.get(0).hasNext() ){
            it.remove(0);
        }
        return sol;
    }

    @Override
    public boolean hasNext() {
        
        if( it.isEmpty() ) return false;
        return it.get(0).hasNext();
        
    }
    
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        
        l1.add(1); l1.add(2);
        l2.add(3);
        l3.add(4); l3.add(5); l3.add(6);
        
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(l1);test.add(l2); test.add(l3);
        
        Vector2D vec2d = new Vector2D( test );
        while( vec2d.hasNext() ){
            System.out.println( vec2d.next() );
        }
    }
}
