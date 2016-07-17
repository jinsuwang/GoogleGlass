/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class CourseSchedule {
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         
        // build frequency
        int[] coursePre = new int[ numCourses ];
        
        for( int i = 0; i < prerequisites.length; i++ ){
            coursePre[ prerequisites[i][0] ]++;
        }
        
        // find all courses do not need prerequisites ;
        Queue<Integer> queue = new LinkedList<>();
        for( int i =0; i < numCourses; i++ ){
            if( coursePre[i] == 0 ){
                queue.add(i);
            }
        }
        
        int numNoPre = queue.size();        
        while( !queue.isEmpty() ){
            int currCourse = queue.poll();
            
            // loop over each pair
            for( int i = 0; i<prerequisites.length; i++ ){
                // find a course's pre is currCourse
                if(prerequisites[i][1] == currCourse ){
                    coursePre[ prerequisites[i][0] ]--;
                    // this course no longer be the pre other the rest
                    if( coursePre[ prerequisites[i][0] ] == 0 ){
                        numNoPre++;
                        queue.add( prerequisites[i][0] );
                    }
                }
            }
            
        }
        return numNoPre == numCourses;
    }
    
    
    // follow up: find all path;
}
