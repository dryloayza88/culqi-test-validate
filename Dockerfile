FROM openjdk:8
COPY /target/culqi-test-validate-?.?*.jar .
CMD java -jar culqi-test-validate-?.?*.jar