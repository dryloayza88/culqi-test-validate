#prueba
FROM openjdk:8-jdk-alpine
COPY ./target/test-2.1.2.RELEASE.jar ./target/test-2.1.2.RELEASE.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","test-2.1.2.RELEASE.jar"]