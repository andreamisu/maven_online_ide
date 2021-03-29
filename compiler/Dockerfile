FROM openjdk:15-jdk-alpine
RUN apk add build-base
COPY target/*.jar app.jar
ENTRYPOINT java -jar /app.jar
