#Dockerfile
FROM openjdk:8-jdk-alpine
COPY . target/test-2.1.2.RELEASE.jar
RUN bash -c 'touch target/test-2.1.2.RELEASE.jar'
CMD ["java","-jar","-Dspring.profiles.active=default","target/test-2.1.2.RELEASE.jar"]