# Stage 1: Build
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /src

# Copy the entire project (including src and pom.xml) to the build container
COPY . .

# Build the project and skip tests
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:21-jdk-slim

WORKDIR /app

# ✅ Copy the built JAR file correctly
COPY --from=build /src/target/employeeCRUD-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
