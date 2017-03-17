/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class IntersectionOfTwoArray {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();

        //Add all elements to set from array 1
        for(int i =0; i< nums1.length; i++) set.add(nums1[i]);
        for(int j = 0; j < nums2.length; j++) {
           // If present in array 2 then add to res and remove from set 
           if(set.contains(nums2[j])) {
                res.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        // Convert ArrayList to array
        int[] arr = new int[res.size()];
        for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
        
    }
    
    /* follow up 
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to num2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?    
    */
}
