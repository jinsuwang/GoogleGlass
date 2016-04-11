/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOD;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class RateLimit {
    Queue<Long> queries;
    int previous_count;
    int qps;
    
    void setQPS( int qps ){
        this.qps = qps;
        queries = new LinkedList<>();
    }
    boolean allowThisRequest(){
        if( qps <= 0 ) return false;
        long now = System.currentTimeMillis();
        // remove old one d
        while( now - queries.peek() > 1000 ){
            queries.poll();
        }
        if ( queries.size() < qps ){
            queries.add( now );
            return true;
        }else{
            return false;
        }
    }
}
