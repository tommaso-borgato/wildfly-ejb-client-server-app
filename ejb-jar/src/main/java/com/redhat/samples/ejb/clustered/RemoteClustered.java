package com.redhat.samples.ejb.clustered;

public interface RemoteClustered {
    void increment();

    void decrement();

    int getCount();
}
