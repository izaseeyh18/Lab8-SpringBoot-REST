# Use Java 17 base image with Maven installed
FROM maven:3.9.3-eclipse-temurin-17-alpine

# Set working directory inside the container
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the Spring Boot app
RUN mvn clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/lab8-0.0.1-SNAPSHOT.jar"]
