FROM openjdk:8-jdk-alpine
COPY /home/vsts/work/1/s/src/target/test-2.1.2.RELEASE.jar test.jar
ENTRYPOINT ["java","-jar","/test.jar"]