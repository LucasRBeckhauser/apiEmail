# Usar uma imagem base do Maven com JDK 21 para construir o projeto
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml .

# Baixar as dependências sem construir o projeto ainda (caching)
RUN mvn dependency:go-offline

# Copiar o código fonte do projeto
COPY src ./src

# Fazer o build do projeto e gerar o arquivo JAR
RUN mvn clean install -DskipTests

# Usar uma imagem mais leve do JRE para rodar o JAR
FROM eclipse-temurin:21-jre-alpine

# Definir o diretório de trabalho no novo estágio
WORKDIR /app

# Copiar o JAR gerado no estágio anterior
COPY --from=build /app/target/MailSender-0.0.1-SNAPSHOT.jar /app/app.jar

# Expor a porta 8080, que é a porta padrão do Spring Boot
EXPOSE 8080

# Definir o comando padrão para rodar o JAR
CMD ["java", "-jar", "app.jar"]
