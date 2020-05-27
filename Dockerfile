#Dockerfile
#FROM openjdk:8-jdk-alpine
#RUN mkdir -p /usr/local/app
#WORKDIR /usr/local/app
#COPY . usr/local/app/test-2.1.2.RELEASE.jar
#EXPOSE 8085
#EXPOSE 8085
#CMD ["java","-jar","/test-2.1.2.RELEASE.jar"]
#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#COPY target/test-2.1.2.RELEASE.jar /app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#EXPOSE 8188

FROM openjdk:8-jdk-alpine
RUN mkdir /usr/myapp
COPY target/test-2.1.2.RELEASE.jar /usr/myapp/app.jar
WORKDIR /usr/myapp
EXPOSE 8080
CMD ["java", "-Xms128m", "-Xmx256m", "-jar", "app.jar"]