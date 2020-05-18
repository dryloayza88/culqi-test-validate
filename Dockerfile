FROM openjdk:8
USER spring:spring
ENTRYPOINT ["java", "-cp", "app:app/lib/x", "hello.TestApplication"]
COPY /target/test-?.?*.jar .
CMD java -jar test-?.?*.jar