# Usar a imagem do Maven para a fase de build
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml
COPY pom.xml .

# Copiar o código fonte do projeto
COPY src ./src

# Fazer o build do projeto e gerar o arquivo JAR
RUN mvn clean package -DskipTests

# Usar a imagem do JRE para o runtime
FROM eclipse-temurin:21-jre-alpine

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado do estágio de build
COPY --from=build /app/target/*.jar app.jar

# Definir o comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
