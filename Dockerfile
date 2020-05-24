#FROM openjdk:8
#COPY /target/test-?.?*.jar .
#CMD java -jar test-?.?*.jar
# Image base
FROM openjdk:8-jdk-alpine
# Copying jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} test.jar