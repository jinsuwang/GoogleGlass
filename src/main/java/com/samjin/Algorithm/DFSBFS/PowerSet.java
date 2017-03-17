/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class PowerSet {
    
    public static Set<Set<Integer>> powerSet( Set<Integer> originalSet ){

        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size())); 
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }		
        return sets;
    }    
    
    public static void main(String[] args) {
        Set<Integer> test = new HashSet();
        test.add(1);
        test.add(2);
        test.add(3);
        Set<Set<Integer>> sol = powerSet( test );
        for( Set<Integer> set : sol ){
            System.out.println(set); 
        }
    }
}
