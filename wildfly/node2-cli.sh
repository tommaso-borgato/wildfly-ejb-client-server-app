#!/bin/bash
cd /home/tborgato/devstudio/tborgato-runtimes/wildfly-12.0.0.Alpha1-SNAPSHOT-NODE-2
echo "embed-server --server-config=standalone-ha.xml"
./bin/jboss-cli.sh
