/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tricky;

import java.util.Iterator;

/**
 *
 * @author Sam
 */
public class PeekingIterator implements Iterator<Integer> {
    
        
        Iterator<Integer> it;
        int next = 0;
        boolean isPeek = false;
                
                
    	public PeekingIterator( Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;     
	}

        // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
            if( !isPeek ){
                next = it.next();
                isPeek = true;
            }
            return next;
        
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if( isPeek ){
                int tmp = next;
                isPeek = false;
                next = 0;
                return tmp;
            }else{
                return it.next();
            }
	}

	@Override
	public boolean hasNext() {
	    return isPeek || it.hasNext();
	}
    
}
