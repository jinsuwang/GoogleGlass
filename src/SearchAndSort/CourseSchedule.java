/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class CourseSchedule {
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case
        if( prerequisites == null) return true;
        int len = prerequisites.length;
        
        if( numCourses == 0 || len == 0 ) return true;
        
        // counter for number of prerequisites
        int[] pCounter = new int[ numCourses ];
        for( int i=0; i < len; i++ ){
            pCounter[ prerequisites[i][0] ]++;
        }
        
        System.out.println(Arrays.toString(pCounter));
        
        // sotr course that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0; i < numCourses; i++ ){
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
    

    /*  Follow Up */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
        if(numCourses == 0 || prerequisites == null || prerequisites.length==0){
            return new int[0];
        }
        
        int[] sol = new int[numCourses];
        List<Integer> path = new ArrayList<Integer>();
        
        // find out how many prerequisite for each course.
        int[] preCount = new int[numCourses];
        for( int i=0; i<prerequisites.length;i++){
            preCount[ prerequisites[i][0] ]++; 
        }
        
        // find course without pre-requiresite.
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if( preCount[i] == 0){
                queue.offer(i);
            }
        }
        
        int taken = queue.size();
        int count = 0;        
        // start to take course.
        
        while( !queue.isEmpty() ){
            int currCourse = queue.poll();
            sol[count++] = currCourse;
            path.add(currCourse);
            for( int i=0; i<prerequisites.length;i++){
                // take next possible course
                if( prerequisites[i][1]== currCourse ){
                    preCount[ prerequisites[i][0] ]--;
                    // take I have finsihed all pre
                    if(  preCount[ prerequisites[i][0] ] == 0 ){
                        taken++;
                        queue.offer( prerequisites[i][0] );
                    }    
                }
            }  
        }
//        System.out.println(Arrays.toString(sol));
        if( count == numCourses) return sol;
        return new int[0];
    }
    
    public static void main(String[] args) {
        int[][] test = {{1,0},{2,0},{3,1},{3,2}};
        int[] sol = findOrder( 4, test );   
        System.out.println(Arrays.toString(sol));
        Assert.assertTrue(sol == {1,2,3,4} )
    }
}
