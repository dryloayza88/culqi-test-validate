FROM openjdk:8-jdk-alpine
RUN mkdir -p /usr/local/app
WORKDIR /usr/local/app
COPY ./target/test-2.1.2.RELEASE.jar /usr/local/app/test-2.1.2.RELEASE.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","test-2.1.2.RELEASE.jar"]