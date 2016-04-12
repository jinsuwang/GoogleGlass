/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer;

/**
 *
 * @author Sam
 */
public class SortColorII {
    
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    /*
    Solution 1: Using the quick sort.
    */ 
    public void sortKColors1(int[] colors, int k) {
        // write your code here
        if (colors == null) {
            return;
        }
        
        quickSort(colors, 0, colors.length - 1);
    }
    
    public void quickSort(int[] colors, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivot = colors[right];
        
        int pos = partition(colors, left, right, pivot);
        
        quickSort(colors, left, pos - 1);
        quickSort(colors, pos + 1, right);
    }
    
    public int partition(int[] colors, int left, int right, int pivot) {
        int leftPoint = left - 1;
        int rightPoint = right;
        
        while (true) {
            while (colors[++leftPoint] < pivot);
            
            while (leftPoint < rightPoint && colors[--rightPoint] > pivot);
            
            if (leftPoint >= rightPoint) {
                break;
            }
            
            swap(colors, leftPoint, rightPoint);
        }
        
        swap(colors, leftPoint, right);
        return leftPoint;
    }
    
    public void swap(int[] colors, int left, int right) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }
    
}
