/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 * @author Sam
 */
public class MyTreeMap {
    public static void main(String[] args) {
        NavigableMap<Integer, String> tm = new TreeMap<Integer, String>();
        tm.put(2, "2");
        tm.put(1, "1");
        tm.put(11, "eleven");
        tm.put(111, "111");
        
        NavigableMap tmp = tm.headMap(12, true);
        Iterator it = tmp.entrySet().iterator();
        while(it.hasNext()){
            Entry e = (Entry)it.next();
            System.out.println(e.getKey());
        }
        
//        System.out.println( tm.floorEntry(11).getValue() );


//        Iterator it = tm.entrySet().iterator();
//        while( it.hasNext() ){
//            Entry e = (Entry)it.next();
//            System.out.println(e.getKey() + " "+ e.getValue());
//        }
    }
}
