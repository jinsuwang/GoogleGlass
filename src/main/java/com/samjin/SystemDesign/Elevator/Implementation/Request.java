/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.SystemDesign.Elevator.Implementation;

/**
 *
 * @author Sam
 */
public class Request {
    
    public long time;
    public int floor;
    public Direction direction;
        public Request(long time, Integer floor, Direction direction) {
                this.time = time;
                this.floor = floor;
                this.direction = direction;
        }    
}
