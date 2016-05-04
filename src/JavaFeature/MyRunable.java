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
public class MyRunable implements Runnable{
    
    
    private String name;  
    public MyRunable(String name) {  
        this.name=name;  
    }  
  
    @Override  
    public void run() {  
      for (int i = 0; i < 5; i++) {  
            System.out.println(name + "运行  :  " + i);  
            try {  
                Thread.sleep((int) Math.random() * 10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }            
    }  
    
}
