/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemDesign.Elevator.Interface;

import SystemDesign.Elevator.Implementation.Request;

/**
 *
 * @author Sam
 */
public interface Receiver {
    
    void processRequest( Request request );
    
}
