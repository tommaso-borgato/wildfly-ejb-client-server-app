/**
 * 
 */
package com.redhat.samples.ejb.stateful;

/**
 * @author tborgato
 *
 */
public interface RemoteCounter {
	void increment();
	 
    void decrement();
 
    int getCount();
}
