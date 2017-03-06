/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company;
import java.util.*;

/**
 *
 * @author Sam
 */

public class ShortedJobFirst {
    
    public static float calWaitingTime(int[] requestTimes, int[] durations){
        if( requestTimes == null || durations == null || requestTimes.length != durations.length ){
            return 0;
        }
        int index = 0;
        int len = requestTimes.length;
        int waitTime = 0;
        int currTime = 0;
        PriorityQueue<Process> heap = new PriorityQueue<>(new Comparator<Process>(){
            public int compare(Process p1, Process p2){
                if( p1.excuteTime == p2.excuteTime ){
                    return p1.arriveTime - p2.arriveTime;
                }
                return p1.excuteTime - p2.excuteTime;
            }
        });
        while( !heap.isEmpty() || index < len ){
            // fetch the minimum exeTime process
            if( !heap.isEmpty() ){
                Process curr = heap.poll();
                waitTime += currTime - curr.arriveTime;
                currTime += curr.excuteTime;
                while( index < len && currTime >= requestTimes[index]){
                    heap.offer(new Process(requestTimes[index], durations[index++]));
                } 
            }else{
                heap.offer( new Process( requestTimes[index], durations[index]));
                currTime = requestTimes[index++];
            }
        }
        return (float)waitTime/len;
    }
    public static void main(String[] args) {
        int[] requestTimes = {0,1,3,9};
        int[] durations = {2,1,7,5};
        System.out.println( calWaitingTime(requestTimes, durations) );
    }
}
