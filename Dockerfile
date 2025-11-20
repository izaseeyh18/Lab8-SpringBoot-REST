# Use Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper and pom.xml first to cache dependencies
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (will be cached unless pom.xml changes)
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the project
COPY src ./src

# Build the Spring Boot app
RUN ./mvnw clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/lab8-0.0.1-SNAPSHOT.jar"]
