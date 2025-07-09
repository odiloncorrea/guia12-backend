# --- 1: BUILD DA APLICAÇÃO ---
FROM maven:3.9.6-openjdk-21 AS build

# Define o diretório de trabalho dentro do contêiner.
WORKDIR /app

COPY pom.xml .

# Baixa todas as dependências do projeto.
RUN mvn dependency:go-offline -B

# Copia o restante do código-fonte da aplicação para o contêiner.
COPY src ./src

# Compila e empacota a aplicação em um arquivo JAR executável.
RUN mvn clean install -DskipTests

# --- 2: EXECUÇÃO DA APLICAÇÃO ---
FROM openjdk:21-jre-slim-buster

# Define o diretório de trabalho onde a aplicação será executada.
WORKDIR /app

# EXPÕE a porta que sua aplicação Spring Boot escuta (8080 por padrão).
EXPOSE 8080

# Copia o arquivo JAR compilado
COPY --from=build /app/target/ds-guia12-0.0.1-SNAPSHOT.jar app.jar

# Define o comando que será executado quando o contêiner for iniciado.
ENTRYPOINT ["java", "-jar", "app.jar"]