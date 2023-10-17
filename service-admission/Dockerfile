FROM openjdk:17-jdk-alpine

COPY target/service-admission-0.0.1-SNAPSHOT.jar admission.jar

ENTRYPOINT ["java","-jar","admission.jar"]