# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable jar file from the target directory to the container
COPY target/CarApp-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

## Use a smaller base image for the runtime environment
#FROM openjdk:17-jdk-slim
#
## Use an appropriate base image with JDK and Maven installed for building
#FROM maven:3.8.4-openjdk-17-slim AS builder
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the Maven wrapper script and pom.xml to cache dependencies
#COPY mvnw .
#COPY mvnw.cmd .
#COPY pom.xml .
#
## Set executable permissions for mvnw
#RUN chmod +x mvnw
#
## Copy the rest of your application source
#COPY src ./src
#
## Build your application with Maven
#RUN ./mvnw clean package -DskipTests
#
## Set the working directory
#WORKDIR /app
#
## Copy the built JAR file from the builder stage
#COPY --from=builder /app/target/CarApp-0.0.1-SNAPSHOT.jar app.jar
#
## Command to run the application
#CMD ["java", "-jar", "app.jar"]
