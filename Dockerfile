FROM payara/server-full
ENV JVM_ARGS="-Ddeployment.resource.validation=false" 
COPY ./target/followUP.war $DEPLOY_DIR
