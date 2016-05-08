/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemDesign.Elevator.Implementation;

import SystemDesign.Elevator.Interface.Command;

/**
 *
 * @author Sam
 */
public class CommandUpAndDown implements Command{
    
    private ElevatorCar elevator;   
    private Request request;

    public CommandUpAndDown(ElevatorCar elevator, Request request){
            this.elevator = elevator;
            this.request = request;
    }
    
   
    @Override
    public void execute() {
        elevator.processRequest( request );
    }
    
}
