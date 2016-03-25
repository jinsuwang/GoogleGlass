/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopologicalSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class CourseSchedule {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case
        if( prerequisites == null) return true;
        int len = prerequisites.length;
        
        if( numCourses == 0 || len == 0 ) return true;
        
        // counter for number of prerequisites
        int[] pCounter = new int[ numCourses ];
        for( int i=0; i < len; i++ ){
            pCounter[ prerequisites[i][0] ]++;
        }
        
        // sotr course that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for( int i =0; i < numCourses; i++ ){
            if( pCounter[i] == 0 ){
                queue.add(i);
            }
        }
        
        int numNoPre = queue.size();
        
        while(!queue.isEmpty()){
            int top = queue.poll();
            // loop over each pair
            for( int i = 0; i<len; i++ ){
                // find a course's pre is top
                if(prerequisites[i][1] == top ){
                    pCounter[ prerequisites[i][0] ]--;
                    // this course no longer be the pre other the rest
                    if( pCounter[ prerequisites[i][0] ] == 0 ){
                        numNoPre++;
                        queue.add( prerequisites[i][0] );
                    }
                }
            }
        }
        return numNoPre == numCourses;
      
    }
    // TODO DFS
}
