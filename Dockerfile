# Use official Java runtime
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the packaged JAR file
COPY target/inventory-management-system.jar app.jar

# Expose application port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
