/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature.Java8;



interface A{
    void call(int i);
}

/**
 *
 * @author Sam
 */
public class JavaLambda {
    
    public static void main(String[] args) {
        
        A p = i -> System.out.println("Calling " + i );
        p.call(999);
    }
}
