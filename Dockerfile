#Dockerfile
FROM openjdk:8-jdk-alpine
COPY . ./test-2.1.2.RELEASE.jar
CMD ["java","-jar","-Dspring.profiles.active=default","/test-2.1.2.RELEASE.jar"]