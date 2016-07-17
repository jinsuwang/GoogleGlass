/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Sam
 */
  public class MergeIntervals {
    
    public static List<Interval> merge(List<Interval> intervals) {
                
        List<Interval> sol = new ArrayList<Interval>(); 
        if( intervals == null || intervals.size() == 0) return sol;
        // sort by start
        Collections.sort( intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        Interval last = intervals.get(0);
        for( int i = 1; i < intervals.size(); i++ ){
            Interval curr = intervals.get(i);
            if( curr.start <= last.end ){
                last.end = Math.max(last.end, curr.end);
            }else{
                sol.add(last);
                last = curr;
            }
        }
        sol.add(last);
        return sol;
    }
    
    
    public static void main(String[] args) {
        Interval i1 = new Interval(1,4);
        Interval i2 = new Interval(0,4);
        
        List<Interval> test = new ArrayList<Interval>();
        test.add(i1); test.add(i2);
        
        List<Interval> sol = merge( test );
        for( Interval e : sol){
            System.out.println(e.start + " " + e.end);
        }
        
    }
}
