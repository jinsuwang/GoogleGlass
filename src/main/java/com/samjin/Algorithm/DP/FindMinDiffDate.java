/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Sam
 */
public class FindMinDiffDate {
    
    
    private static class Record{
        public Integer purchaseTime;
        public String name;
        Record( String name, Integer purchaseTime ){
            this.purchaseTime = purchaseTime;
            this.name = name;
        }
    }
    
    static class RecordComparator implements Comparator<Record>{
        @Override
        public int compare(Record r1, Record r2) {
            return r1.purchaseTime.compareTo(r2.purchaseTime);
        }
    }
    

    public static int findMin(Record[] records,String a, String b){
        int indexA = -1;
        int indexB = -1;
        int minDiff = Integer.MAX_VALUE;
        for( int i=0; i < records.length; i++ ){
            
        }
        return -1;
    }
    
    public static void main(String[] args) {
        
        Record r1 = new Record("iphone" , 1);
        Record r2 = new Record("iphone" , 2);
        Record[] test = { r2, r1 };
        Arrays.sort(test, new RecordComparator());
        for( int i = 0; i < test.length; i++ ){
            System.out.println(test[i].name + "--" +  test[i].purchaseTime );
        }
    }
}
