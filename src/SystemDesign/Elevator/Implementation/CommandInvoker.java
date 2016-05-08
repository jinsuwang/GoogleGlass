/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemDesign.Elevator.Implementation;

import SystemDesign.Elevator.Interface.Command;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class CommandInvoker {
    
    private List<Command> history = new ArrayList<Command>();
    
    public void storeAndExecute(Command cmd) {
            this.history.add(cmd); 
            cmd.execute();
    }   
}
