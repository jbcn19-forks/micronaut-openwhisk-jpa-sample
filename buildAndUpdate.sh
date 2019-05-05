mvn clean install

ibmcloud fn action update mnJpaSample target/micronaut-openwhisk-jpa-sample-0.1.jar --main  com.ibm.openwhisk.micronaut.jpa.sample.OpenWhiskBootstrap --docker prpatel/micronaut

#ibmcloud fn action invoke mnJpaSample -b
