/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company;

/**
 *
 * @author Sam
 */
class Process{
    public int excuteTime;
    public int arriveTime;
    Process( int arrTime, int excTime ){
        this.excuteTime = excTime;
        this.arriveTime = arrTime;
    }
}

