/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature;

/**
 *
 * @author Sam
 */
public class JavaGabargeCollector {
    
    
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(Integer.toHexString(s.hashCode()));
        s = "apple";
        System.out.println(Integer.toHexString(s.hashCode()));
    
    }
    
}
