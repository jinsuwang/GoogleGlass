/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.SystemDesign.Elevator.Implementation;

import com.samjin.SystemDesign.Elevator.Interface.Receiver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class ElevatorCar implements Receiver {
    
    private class Process implements Runnable{
        @Override
        public void run() {
            process();
        }
    }
    
    public Direction direction = Direction.UP;
    // is current Elevator is under processing request
    public Boolean idle = Boolean.TRUE;
    public int currFloor = 1;
    public DoorState door = DoorState.CLOSED;
    
    
    public List<Request> upQueue = new ArrayList<Request>();
    public List<Request> downQueue = new ArrayList<Request>();
    public List<Request> curQueue = new ArrayList<Request>();
    
    private Thread processingThread;
    
    
    public void process() {
        
    }
    

    @Override
    public synchronized void processRequest(Request request) {
        
        if( idle ){
            curQueue.add(request);
            processingThread = new Thread( new Process() );
            processingThread.start();
        }else{
            if( request.direction == Direction.UP ){
                if( direction == Direction.Down ){
                    addRequestToUpQueue( request ); 
                }else{
                    if( request.floor >= currFloor ){
                        // Elevator could handle this request.
                        addRequestToUpQueueUp( request );
                    }else{
                        // next available up elevator should handle
                        addRequestToUpQueue( request );
                    }
                }
            }else{  // request is down
                if( direction == Direction.UP ){
                    addRequestToDownQueue(request);
                }else{
                    if(request.floor <= currFloor){
                        addRequestToCurQueueDown(request);
                    }else{
                        addRequestToDownQueue(request);
                    }
                }
            }
        }
        
        if( curQueue.isEmpty() ){
            preProcessNextQueue();
        }
        
    }
    
    
    
    private void addRequestToUpQueueUp(Request request) {
        
        
        
    }
    
    private void addRequestToUpQueue(Request request) { 
        upQueue.add(request);
        int n = upQueue.size();
        for(int i=0; i<n; i++){
            // move largest one to the end.
            Request task1 = upQueue.get(i);
            Request task2 = upQueue.get(n-1);
            if(task2.floor < task1.floor){
                upQueue.set(i, task2);
                upQueue.set(n-1, task1);
            }
        }
    }
    
    private void addRequestToDownQueue(Request request){
            downQueue.add(request);
            int n = downQueue.size();
            for(int i=0; i<n; i++){
                    Request task1 = downQueue.get(i);
                    Request task2 = downQueue.get(n-1);
                    if(task2.floor > task1.floor){
                            downQueue.set(i, task2);
                            downQueue.set(n-1, task1);
                    }
            }
    }

    
    private void addRequestToCurQueueUp(Request request){
            curQueue.add(request);
            int n = curQueue.size();
            for(int i=0; i<n; i++){
                    Request task1 = curQueue.get(i);
                    Request task2 = curQueue.get(n-1);
                    if(task2.floor < task1.floor){
                            curQueue.set(i, task2);
                            curQueue.set(n-1, task1);
                    }
            }
    }
    
    	
    private void addRequestToCurQueueDown(Request request){
            curQueue.add(request);
            int n = curQueue.size();
            for(int i=0; i<n; i++){
                    Request task1 = curQueue.get(i);
                    Request task2 = curQueue.get(n-1);
                    if(task2.floor > task1.floor){
                            curQueue.set(i, task2);
                            curQueue.set(n-1, task1);
                    }
            }
    }
    
    private void preProcessNextQueue() {
            if ( getLowestTimeUpQueue() > getLowestTimeDownQueue()) {
                    this.direction = Direction.UP;
                    curQueue = upQueue;
                    upQueue.clear();
            } else {
                    this.direction = Direction.Down;
                    curQueue = downQueue;
                    downQueue.clear();;
            }
    }
    
    	
	private long getLowestTimeUpQueue() {
		long lowest = Long.MAX_VALUE;
		for (Request r : upQueue) {
			if (r.time < lowest)
				lowest = r.time;
		}
		return lowest;
	}

	private long getLowestTimeDownQueue() {
		long lowest = Long.MAX_VALUE;
		for (Request r : downQueue) {
			if (r.time < lowest)
				lowest = r.time;
		}
		return lowest;
	}
    
}
