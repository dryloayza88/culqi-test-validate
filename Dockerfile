FROM openjdk:8
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ENTRYPOINT ["java", "-cp", "app:app/lib/x", "hello.TestApplication"]
COPY /target/test-?.?*.jar .
CMD java -jar test-?.?*.jar