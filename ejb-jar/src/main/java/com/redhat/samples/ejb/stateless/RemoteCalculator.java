/**
 * 
 */
package com.redhat.samples.ejb.stateless;

/**
 * @author tborgato
 *
 */
public interface RemoteCalculator {
    int add(int a, int b);
    
    int subtract(int a, int b);
}
