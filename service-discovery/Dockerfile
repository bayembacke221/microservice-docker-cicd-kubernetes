FROM openjdk:17-jdk-alpine

COPY target/service-discovery-0.0.1-SNAPSHOT.jar discovery.jar

ENTRYPOINT ["java","-jar","discovery.jar"]