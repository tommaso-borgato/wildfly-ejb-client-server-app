package com.redhat.qe.rest;

import com.redhat.qe.ejb.stateful.LocalCounter;
import com.redhat.qe.ejb.stateless.LocalCalculator;

import javax.ejb.EJB;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ejb")
public class EjbRestClient {
	
	@EJB
	private LocalCounter counter;
	
	@EJB
	private LocalCalculator calculator;
	
	@GET
    @Path("/counter")
    public Integer getAndIncrement() {
		counter.increment();
		return counter.getCount();
    }
 
    @GET
    @Path("/calculator/add/{aa}/{bb}")
    public Integer add(@PathParam("aa") Integer a, @PathParam("bb") Integer b) {
    	return calculator.add(a, b);
    }
}
