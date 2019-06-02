FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD xscloud-docker-demo-1.0-SNAPSHOT.jar xscloud-docker-demo-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Xmx256m -Xms256m","-jar","/xscloud-docker-demo-1.0-SNAPSHOT.jar"]