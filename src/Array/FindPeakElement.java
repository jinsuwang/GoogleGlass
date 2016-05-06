/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

/**
 *
 * @author Sam
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        
        if( num == null || num.length < 2) return 0;
        
        int l = 0;
        int r = num.length -1 ;
        int n = num.length;
        
        while( l + 1 < r ){
            
            int mid = l + ( r - l ) / 2;
            
             mid = l + (r - l) / 2;
            if((mid == 0 || num[mid] >= num[mid - 1]) &&
               (mid == n - 1 || num[mid] >= num[mid + 1])) {
                    return mid;
            }else if(mid > 0 && num[mid-1] > num[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return num[l] > num[r] ? l: r;     
           
    }
}
