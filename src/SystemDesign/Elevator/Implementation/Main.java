/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemDesign.Elevator.Implementation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        List<Integer> l = new ArrayList<Integer>();
        l.add(7);
        l.add(6);
        l.add(5);
        l.add(4);
        l.add(3);
        l.add(2);
        l.add(1);
     
        int n = l.size();
        for(int i=0; i < n; i++){
            int task1 = l.get(i);
            int task2 = l.get(n-1);
            if(task2 < task1){
                l.set(i, task2);
                l.set(n-1, task1);
            }
        }
        
        System.out.println(l.toString());
        
    }
}
