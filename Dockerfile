FROM openjdk:8
COPY /target/test-?.?*.jar .
CMD java -jar test-?.?*.jar