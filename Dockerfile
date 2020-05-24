# Image base
FROM openjdk:8-jdk-alpine
# Copying jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} test.jar
# Extracting jar
RUN jar -xf test.jar
# Moving dependencies
RUN mkdir test
RUN mkdir test/lib
RUN mkdir test/META-INF
RUN mv BOOT-INF/lib test/lib
RUN mv META-INF test/META-INF
RUN mv BOOT-INF/classes test
# Adding a user to run the app, not root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
EXPOSE 80
# Starting the app
ENTRYPOINT ["java","-jar","/test.jar"]



#FROM openjdk:8-jdk-alpine
#RUN mkdir -p /usr/local/app
#WORKDIR /usr/local/app
#EXPOSE 8085
#ENTRYPOINT ["java","-jar","test-2.1.2.RELEASE.jar"]
#COPY /home/vsts/work/1/a/target/test-2.1.2.RELEASE.jar /usr/local/app/test-2.1.2.RELEASE.jar