/**
 * 
 */
package com.redhat.qe.ejb.stateful;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * @author tborgato
 *
 */
@Stateful
@Remote(RemoteCounter.class)
@Local(LocalCounter.class)
public class CounterBean implements RemoteCounter {
 
    private int count = 0;
 
    @Override
    public void increment() {
        this.count++;
    }
 
    @Override
    public void decrement() {
        this.count--;
    }
 
    @Override
    public int getCount() {
        return this.count;
    }
}