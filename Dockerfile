FROM maven:3.8.4-openjdk-17 as build

WORKDIR /app

# Copy your project files into the Docker image
COPY demo/ /app/

# Build the project using Maven and skip the tests
RUN mvn clean package -DskipTests

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
