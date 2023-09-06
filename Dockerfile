# Use the official OpenJDK 8 image with Alpine Linux as the base image
FROM openjdk:8-jdk-alpine as build

# Set the working directory within the container to /workspace/app
WORKDIR /workspace/app

# Copy the Maven Wrapper files and configuration for improved build consistency
COPY mvnw .
COPY .mvn .mvn

# Copy the project's POM file
COPY pom.xml .

# Copy the source code of the Spring Boot application
COPY src src

# Make the Maven Wrapper executable
RUN chmod +x ./mvnw

# Build the project with Maven, skipping tests to speed up the process
RUN ./mvnw install -DskipTests

# Create a directory for the application's dependencies
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Create a new stage for the final image
FROM openjdk:8-jdk-alpine

# Explicitly expose the desired port that the application will listen on
EXPOSE 8080

# Create a volume for temporary storage (used for things like storing application logs)
VOLUME /tmp

# Define an argument for specifying the location of the application's dependencies
ARG DEPENDENCY=/workspace/app/target/dependency

# Copy the application's dependencies from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Define the entry point for running the application
ENTRYPOINT ["java","-cp","app:app/lib/*","com.github.curriculeon.DemoApplication"]