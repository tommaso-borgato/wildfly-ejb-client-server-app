/**
 * 
 */
package com.redhat.qe.ejb.stateful;

/**
 * @author tborgato
 *
 */
public interface LocalCounter {
	void increment();
	 
    void decrement();
 
    int getCount();
}
