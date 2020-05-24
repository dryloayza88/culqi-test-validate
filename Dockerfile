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

EXPOSE 80
# Starting the app
#ENTRYPOINT ["java","-cp","app:app/lib/*","me.javirpo.guasa.backend.GuaSaBackendApplication"]
ENTRYPOINT ["java","-jar","/test.jar"]