# Stage 1: Build
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Set the working directory for development
WORKDIR /src

# Copy the entire project (including src and pom.xml) to the build container
COPY . .

# Build the project and skip tests
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:21-jdk-slim

# Set the working directory in the runtime container
WORKDIR /app

# Copy the JAR file from the build stage (correct path, considering your structure)
COPY --from=build /src/employeeCRUD/target/employeeCRUD-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]
