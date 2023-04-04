# Use a lightweight Java 18 base image
FROM openjdk:18-alpine

# Set the working directory to /Multithreaded_Bot
WORKDIR /Multithreaded_Bot

# Copy the JAR file into the container
COPY DiscordBot_With_Multithreading-1.0-SNAPSHOT-jar-with-dependencies.jar .

# Set the command to run the application with one argument
CMD ["java", "-jar", "DiscordBot_With_Multithreading-1.0-SNAPSHOT-jar-with-dependencies.jar", "${START_ARG}"]

# Expose port 8080 to port 3333
EXPOSE 8080

ENV START_ARG="null"