FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/clinica-0.0.1.jar
COPY ${JAR_FILE} app_veterinaria.jar
EXPOSE 9475
ENTRYPOINT ["java", "-jar", "app_veterinaria.jar"]