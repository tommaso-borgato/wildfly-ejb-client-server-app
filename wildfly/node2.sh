#!/bin/bash
cd /home/tborgato/devstudio/tborgato-runtimes/wildfly-12.0.0.Alpha1-SNAPSHOT-NODE-2
./bin/standalone.sh --server-config=standalone-ha.xml "-Dprogram.name=JBossTools: WildFly 12.0 NODE 2" -Dorg.jboss.resolver.warning=true -Djava.net.preferIPv4Stack=true -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.dgc.server.gcInterval=3600000 -Djboss.modules.system.pkgs=org.jboss.byteman -Djava.awt.headless=true "-Dorg.jboss.boot.log.file=/home/tborgato/devstudio/tborgato-runtimes/wildfly-12.0.0.Alpha1-SNAPSHOT-NODE-2/standalone/log/boot.log" "-Dlogging.configuration=file:/home/tborgato/devstudio/tborgato-runtimes/wildfly-12.0.0.Alpha1-SNAPSHOT-NODE-2/standalone/configuration/logging.properties" "-Djboss.home.dir=/home/tborgato/devstudio/tborgato-runtimes/wildfly-12.0.0.Alpha1-SNAPSHOT-NODE-2" -Dorg.jboss.logmanager.nocolor=true -Djboss.bind.address.management=localhost -Djboss.socket.binding.port-offset=100 -Djboss.node.name=node2 

