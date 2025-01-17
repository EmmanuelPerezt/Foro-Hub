
FROM openjdk:17-jdk-slim


WORKDIR /app


COPY target/app.jar app.jar

COPY src/main/resources/application-prod.properties application-prod.properties


EXPOSE 8080


ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]