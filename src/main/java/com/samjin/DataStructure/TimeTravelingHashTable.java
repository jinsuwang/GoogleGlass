package com.samjin.DataStructure;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class TimeTravelingHashTable<K,V> {
    Map<K, TreeMap<Float,V>> TL_map = new HashMap<>();
    
    public V get( K k, Float time){
        if( TL_map.containsKey(k) == false) return null;
        if ( TL_map.get(k).containsKey(time) )
            return TL_map.get(k).get(time);
        else{
            Float lastest = TL_map.get(k).lastKey();
            return TL_map.get(k).get(lastest);
        }
    }
    
    public void put(K k,Float time, V value){
        if( TL_map.containsKey(k))
            TL_map.get(k).put(time, value);
        else{
            TreeMap<Float,V> t = new TreeMap<>();
            t.put( time, value );
            TL_map.put(k,t);
        }
    }
}
