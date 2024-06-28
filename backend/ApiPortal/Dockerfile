# Etapa 1: Construir o jar
FROM maven:3.8.6-amazoncorretto-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -Dspring.profiles.active=prod

# Etapa 2: Criar a imagem final
FROM amazoncorretto:17
WORKDIR /app
COPY --from=build /app/target/*.jar apiportal.jar
EXPOSE 8084
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "apiportal.jar", "--spring.profiles.active=prod"]
# FROM amazoncorretto:17
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} apiportal.jar
# CMD apt-get update -y
# ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/apiportal.jar"]