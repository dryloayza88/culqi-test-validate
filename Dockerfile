#Dockerfile
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY . ./target/test-2.1.2.RELEASE.jar
CMD java -jar test-2.1-2.RELEASE.jar
#CMD ["java","-jar","-Dspring.profiles.active=default","target/test-2.1.2.RELEASE.jar"]