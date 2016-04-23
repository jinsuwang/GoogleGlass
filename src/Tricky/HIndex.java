/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tricky;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class HIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort( citations );
        if( citations == null || citations.length == 0 ) return 0;
        for( int i = 0; i < citations.length; i++ ){
            int citationsCount = citations[i];
            int rank = citations.length  - i;
//            System.out.println( citationsCount + "  "+ rank );
            if( citationsCount >=  rank ){
                return rank;
            }
        }
        return 0;
    }
    
    
    public static int hIndex2(int[] citations) {
        if( citations == null || citations.length == 0) return 0;

        int left = 0;
        int right = citations.length-1;
        int len = citations.length;
        
        while( left < right ){
            System.out.println( left +"  " +right);
            int mid = left + ( right - left )/2;
            if( len - mid <= citations[mid] ){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return len - left;
    }
    
    
    
    public static void main(String[] args) {
        
        int[] citations = { 0 };
        System.out.println( hIndex2(citations) );
    }
}
