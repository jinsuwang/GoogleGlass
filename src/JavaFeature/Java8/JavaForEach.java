/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature.Java8;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sam
 */
public class JavaForEach {
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.forEach( e -> System.out.println(e) );
    }
    
}
