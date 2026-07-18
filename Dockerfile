# Base image with Java 17
FROM eclipse-temurin:17-jre

# Create working directory inside container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Application listens on port 8080
EXPOSE 8085

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]