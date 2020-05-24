FROM openjdk:8-jdk-alpine
WORKDIR /home/vsts/work/1/s/src/target
COPY test-2.1.2.RELEASE.jar .
CMD java -jar test-2.1.2.RELEASE.jar