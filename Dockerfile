# Estágio 1: build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Estágio 2: runtime
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/desafio-cadastro-ninja-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
