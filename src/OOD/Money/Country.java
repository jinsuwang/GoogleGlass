/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOD.Money;

/**
 *
 * @author Sam
 */
public enum Country {
    USA("USA"), CANADA("CAN");
    
    String countryCode;
    
    Country( String countryCode ){
        this.countryCode = countryCode;
    }
}
