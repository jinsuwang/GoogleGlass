/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.eBay;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class findLongest {
    
    private static String findLongest(Set<String> dict, Set<String> elements) {
        
        Iterator<String> it = dict.iterator();
        
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        
        });
        
        while( it.hasNext() ) pq.offer( it.next() );
        
        while( !pq.isEmpty() ){
            String curr =  pq.poll();
            System.out.println("curr: " + curr  );
            if( canFind(curr, elements, 0) ) return curr;
        }
        
        return null;
    }

    private static boolean canFind(String curr, Set<String> elements, int index) {
        if( index == curr.length() ){
            return true;
        }
        if ( elements.contains(curr.substring(index, index+1))){
           return canFind( curr, elements, index+1);
        }
        if ( index <= curr.length() - 2 && elements.contains(curr.substring(index, index+2))){
           return canFind( curr, elements, index+2);
        }
        return false;
    }
    
    public static void main(String[] args) {
        Set<String> elements = new HashSet<String>();
        elements.add("a");
        elements.add("bc");
    
        Set<String> dict = new HashSet<String>();
        dict.add( "aabc" );
        dict.add( "abc" );
        
//        System.out.println(findLongest( dict, elements ));

        System.out.println("can Find: " + canFind("abc", elements, 0));
        
    }
}
