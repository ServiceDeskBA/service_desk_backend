# ===============================
# 🏗️ Etapa 1: Build da aplicação
# ===============================
FROM maven:3.9.9-amazoncorretto-24 AS build

WORKDIR /app

# Copia os arquivos do Maven
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte
COPY src ./src

# Compila e empacota o projeto (gera o JAR)
RUN mvn clean package -DskipTests

# ===============================
# 🚀 Etapa 2: Execução da aplicação
# ===============================
FROM amazoncorretto:24

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]