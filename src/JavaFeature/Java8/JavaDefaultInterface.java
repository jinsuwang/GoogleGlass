/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature.Java8;



interface Phone{
    void call();
    default void message(){
        System.out.println("Sending Message");
    }
}

class AndriodPhone implements Phone{
    @Override
    public void call() {
        System.out.println("Calling...");
    }
}

/**
 *
 * @author Sam
 */
public class JavaDefaultInterface{
    
    public static void main(String[] args) {
        Phone p = new AndriodPhone();
        p.message();
    }
}
