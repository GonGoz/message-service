# Build stage
FROM maven:3.8.7-eclipse-temurin-17-alpine as builder
WORKDIR /opt/app
COPY ./src ./src
COPY pom.xml ./
RUN mvn clean install -DskipTests

# Package stage
FROM openjdk:17
WORKDIR /opt/app
COPY --from=builder /opt/app/target/message-service.jar message-service.jar
ENTRYPOINT ["java", "-jar", "message-service.jar"]