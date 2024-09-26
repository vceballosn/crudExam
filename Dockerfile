FROM openjdk:17-oracle
COPY target/exam-0.0.1-SNAPSHOT.jar exam.jar
EXPOSE 8021
ENTRYPOINT ["java", "-jar", "/exam.jar"]

LABEL autor="vladimir ceballos"