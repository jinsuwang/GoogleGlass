
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class RobHouse {
    
    /*
        [ 1 ,3, 2, 4, 6, 8 ];
    
    */
    
    public static int findMaximumValue( int[] houses ){
        
        int[] value = new int[houses.length];
    
        value[0] = houses[0];
        value[1] = houses[1];
        value[2] = value[0] + houses[2]; 
        
        for( int i = 3; i < houses.length; i++ ){
            value[i] = Math.max( value[i-2] + houses[i], houses[i] + value[i-3]);
        } 
        
        System.out.println( Arrays.toString(value) );
        
        return Math.max( value[houses.length-1], value[houses.length-2] );
    }
    
    public static void main(String[] args) {
        int[] test =  {  2 ,3, 2, 4, 6, 8 };
        System.out.println(findMaximumValue( test ));
        
    }
}
    

