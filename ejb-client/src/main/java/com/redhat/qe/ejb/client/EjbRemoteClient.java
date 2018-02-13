package com.redhat.qe.ejb.client;

import com.redhat.qe.ejb.stateful.RemoteCounter;
import com.redhat.qe.ejb.stateless.RemoteCalculator;
import org.wildfly.naming.client.WildFlyInitialContextFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.security.PrivilegedActionException;
import java.util.Properties;

/**
 * Traditional EJB Client </BR>
 * <UL>
 *     <LI>Stateless CalculatorBean</LI>
 *     <LI>Stateful CounterBean</LI>
 * </UL>
 */
public class EjbRemoteClient {
	
	public static void main(String[] args)
            throws NamingException, PrivilegedActionException, InterruptedException {
		
		System.out.println(
		        "===============================================\n" +
                " CalculatorBean on NODE-1 \n" +
                "===============================================");
        InitialContext ctx1 = new InitialContext(getCtxPropertiesNode1());
        String lookupNameRemoteCalculator = 
        		"ejb:/ejb-server/CalculatorBean!com.redhat.qe.ejb.stateless.RemoteCalculator";
        RemoteCalculator bean1 = (RemoteCalculator)ctx1.lookup(lookupNameRemoteCalculator);
        System.out.println("RemoteCalculator.add(1,2)=" + bean1.add(1, 2) + "\n");
        ctx1.close();
        
        System.out.println(
                "===============================================\n" +
                " CounterBean on NODE-2 \n" +
                "===============================================");
        InitialContext ctx2 = new InitialContext(getCtxPropertiesNode2());
        String lookupNameRemoteCounter = 
        		"ejb:/ejb-server/CounterBean!com.redhat.qe.ejb.stateful.RemoteCounter?stateful";
        RemoteCounter bean2 = (RemoteCounter)ctx2.lookup(lookupNameRemoteCounter);
        System.out.println("RemoteCounter.getCount()=" + bean2.getCount());
        System.out.println("RemoteCounter.increment()");
        bean2.increment();
        System.out.println("RemoteCounter.getCount()=" + bean2.getCount());
        ctx2.close();
    }

    /**
     * Start WILDFLY NODE-1 (wildfly/node1.sh) before executing
     * @return
     */
    public static Properties getCtxPropertiesNode1() {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, WildFlyInitialContextFactory.class.getName());
        props.put(Context.PROVIDER_URL, "remote+http://127.0.0.1:8080");
        props.put(Context.SECURITY_PRINCIPAL, "ejb-remote-user");
        props.put(Context.SECURITY_CREDENTIALS, "ejb-remote-user");
        return props;
    }

    /**
     * Start WILDFLY NODE-2 (wildfly/node2.sh) before executing
     * @return
     */
    public static Properties getCtxPropertiesNode2() {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, WildFlyInitialContextFactory.class.getName());
        props.put(Context.PROVIDER_URL, "remote+http://127.0.0.1:8180");
        props.put(Context.SECURITY_PRINCIPAL, "ejb-remote-user");
        props.put(Context.SECURITY_CREDENTIALS, "ejb-remote-user");
        return props;
    }

}
