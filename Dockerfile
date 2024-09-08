# Build stage
FROM openjdk:23-ea-17-jdk-slim AS build

# Set working directory
WORKDIR /app

# Copy the Maven/Gradle wrapper and build files first (to utilize Docker caching)
COPY mvnw ./
COPY .mvn .mvn
COPY pom.xml ./

# Install Maven dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Package the application (without running tests to speed up build)
RUN ./mvnw package -DskipTests

# Run stage
FROM gcr.io/distroless/java17-debian12

# Set working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]