FROM openjdk:8-jdk-alpine
COPY /target/*.jar test.jar
ENTRYPOINT ["java","-jar","/test.jar"]