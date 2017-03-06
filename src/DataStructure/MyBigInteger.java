/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import Tricky.BigInteger;

/**
 *
 * @author Sam
 */
public class MyBigInteger { 
  
    // The sign of this integer - true for a positive number, and false 
    // otherwise 
    private boolean sign = true; 
  
    // digits[0] is the most significant digit of the integer, and 
    // the last element of this array is the least significant digit. 
    // For example, if we have a BigInteger of value 34, then 
    // digits[0] = 3 and digits[1] = 4. 
    private byte[] digits; 
  
    public MyBigInteger() { 
        this.digits = new byte[1]; 
        this.digits[0] = 0; 
    } 
  
    public MyBigInteger(byte[] digits) { 
        this.digits = digits; 
    } 
  
    /** 
     * Initializes a <code>BigInteger</code> according to a string. The form of 
     * <code>numberStr</code> is a string consisting of all digits ranging from 
     * 0 to 9, following an OPTIONAL minus symbol (i.e., "-"). For example, 
     * "1234567891234567" and "-17788399934334388347734" are both valid. 
     *  
     * @param numberStr 
     *            a number expressed as a string 
     */
    public MyBigInteger(String numberStr) { 
        if(numberStr.charAt(0) == '-'){   
            sign = false;   
            StringBuilder sb = new StringBuilder(numberStr);   
            sb.deleteCharAt(0);   
            numberStr = new String(sb);   
        }else{   
            sign = true;   
        }   

        digits = new byte[numberStr.length()];   
        for(int i = 0;i < numberStr.length();i++){   
            switch(numberStr.charAt(i)){   
            case '0': digits[i] = 0;break;   
            case '1': digits[i] = 1;break;   
            case '2': digits[i] = 2;break;   
            case '3': digits[i] = 3;break;   
            case '4': digits[i] = 4;break;   
            case '5': digits[i] = 5;break;   
            case '6': digits[i] = 6;break;   
            case '7': digits[i] = 7;break;   
            case '8': digits[i] = 8;break;   
            case '9': digits[i] = 9;break;   
            }   
        }  
    } 
  
    /** 
     * Performs addition. 
     *  
     * @param another 
     *            another <code>BigInteger</code> object 
     * @return this+another 
     */
    public MyBigInteger add(BigInteger another) {
        // YOU FILL THIS IN 
    } 
  
    /** 
     * Performs addition. 
     *  
     * @param num 
     *            an integer 
     * @return this+num 
     */
    public BigInteger add(int num) { 
        // YOU FILL THIS IN 
    } 
  
    /** 
     * Performs subtraction. 
     *  
     * @param another 
     *            another <code>BigInteger</code> object 
     * @return this-another 
     */
    public BigInteger subtract(BigInteger another) { 
        // YOU FILL THIS IN 
    } 
  
    /** 
     * Performs subtraction. 
     *  
     * @param num 
     *            an integer 
     * @return this-num 
     */
    public BigInteger subtract(int num) { 
        // YOU FILL THIS IN 
    } 
  
    /** 
     * Performs multiplication. 
     *  
     * @param another 
     *            another <code>BigInteger</code> object 
     * @return this*another 
     */
    public BigInteger multiply(BigInteger another) { 
        // YOU FILL THIS IN
        return null;
    } 
  
    /** 
     * Performs multiplication. 
     *  
     * @param num 
     *            an integer 
     * @return this*num 
     */
    public BigInteger multiply(int num) { 
        // YOU FILL THIS IN
        return null;
    } 
  
    public String toString() { 
        StringBuffer buf = new StringBuffer(); 
        if (!sign) { 
            buf.append("-"); 
        } 
        for (byte d : digits) { 
            buf.append(d); 
        } 
        return buf.toString(); 
    } 

}
