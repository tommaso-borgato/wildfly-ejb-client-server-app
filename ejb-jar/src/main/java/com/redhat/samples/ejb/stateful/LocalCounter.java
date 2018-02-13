/**
 * 
 */
package com.redhat.samples.ejb.stateful;

/**
 * @author tborgato
 *
 */
public interface LocalCounter {
	void increment();
	 
    void decrement();
 
    int getCount();
}
