/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature.Locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Sam
 */
public class Locks {
    
    private Object data = null;
    
    ReadWriteLock rwlock = new ReentrantReadWriteLock();
    
    public void get(){
        rwlock.readLock().lock();      
        try{
            System.out.println(Thread.currentThread().getName() + " 准备读数据!");  
            Thread.sleep((long) (Math.random() * 1000));  
            System.out.println(Thread.currentThread().getName() + " 读出的数据");
        }catch( InterruptedException e ){
            e.printStackTrace();
        }finally{
            rwlock.readLock().unlock();
        }      
    }
    
    public void put( Object data ){
            
        rwlock.writeLock().lock();

        try{
            System.out.println(Thread.currentThread().getName() + " 准备写数据!");  
            Thread.sleep((long) (Math.random() * 1000));  
            this.data = data;  
            System.out.println(Thread.currentThread().getName() + " 写入的数据: " + data);  
        }catch( Exception e ){
            e.printStackTrace();
        }finally{
            rwlock.writeLock().unlock();
        }
    }
}    

