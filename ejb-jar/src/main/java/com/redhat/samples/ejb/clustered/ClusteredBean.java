package com.redhat.samples.ejb.clustered;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import org.jboss.ejb3.annotation.Clustered;

@Stateful
@Clustered
@Remote(RemoteClustered.class)
public class ClusteredBean implements RemoteClustered {
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
