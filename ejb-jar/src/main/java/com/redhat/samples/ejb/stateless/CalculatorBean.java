/**
 * 
 */
package com.redhat.samples.ejb.stateless;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author tborgato
 *
 */
@Stateless
@Remote(RemoteCalculator.class)
@Local(LocalCalculator.class)
public class CalculatorBean implements RemoteCalculator {
 
    @Override
    public int add(int a, int b) {
        return a + b;
    }
 
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
