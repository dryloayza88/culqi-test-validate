FROM openjdk:8-jdk-alpine
COPY target/test-2.1.2.RELEASE.jar ./
CMD java -jar test-2.1.2.RELEASE.jar