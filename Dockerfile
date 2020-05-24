FROM openjdk:8-jre-alpine
COPY /target/test.jar .
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/test.jar"]