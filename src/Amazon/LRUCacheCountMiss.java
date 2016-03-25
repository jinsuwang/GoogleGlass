/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;
import java.util.*;

/**
 *
 * @author Sam
 */
public class LRUCacheCountMiss {
    public static int countMiss(int[] arr, int size) {
        if( arr == null || arr.length < 1){
            return 0;
        }
        List<Integer> cache = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if( cache.contains( arr[i] ) ){
                cache.remove( cache.indexOf(arr[i]));
                cache.add(arr[i]);
            }else{
                cache.add(arr[i]);
                count++;
            }
            if( cache.size() > size ){
                cache.remove(0);
            }
        }
        return count;
    }
}
