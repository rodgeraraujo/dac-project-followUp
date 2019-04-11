FROM payara/server-full
ENV JVM_ARGS="-Ddeployment.resource.validation=false" 
COPY ./target/followUp.war $DEPLOY_DIR
