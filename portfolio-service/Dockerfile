FROM openjdk:17

ARG JAR_FILE=target/*.jar

# Copy the JAR file into the image
COPY ./target/portfolio-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
