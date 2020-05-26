#Dockerfile
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.culqi.test.TestApplication"]
#COPY target/test-2.1.2.RELEASE.jar .
#CMD java -jar test-?-?-?.RELEASE.jar
#CMD ["java","-jar","-Dspring.profiles.active=default","target/test-2.1.2.RELEASE.jar"]