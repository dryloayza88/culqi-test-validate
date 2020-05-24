FROM openjdk:8-jdk-alpine
COPY /target/test-?.?.?.RELEASE.jar .
CMD java -jar test-?.?.?.RELEASE.jar