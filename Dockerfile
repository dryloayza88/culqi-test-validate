FROM openjdk:8-jdk-alpine
COPY /home/vsts/work/1/s/target/test-2.1.2.RELEASE.jar .
CMD java -jar test-2.1.2.RELEASE.jar