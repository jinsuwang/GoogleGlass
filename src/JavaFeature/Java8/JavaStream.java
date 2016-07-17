/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature.Java8;

/**
 *
 * @author Sam
 */
public class JavaStream {
    
    
    
    public static class Person{
        String firstName, lastName;
        int age;
        Gender gender;
        
        public Person(String firstName, String lastName, int age, Gender g ){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age; 
            this.gender = g;
        }
        
        
        
        public static enum Gender{
            MALE, FEMALE;
        }
    }
    
    public static void main(String[] args) {
        
        
        
    }
    
}
