# Usando uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim AS build

# Definindo o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiando os arquivos do projeto
COPY pom.xml mvnw ./
COPY .mvn .mvn
COPY src src

# Baixando dependências e compilando o projeto
RUN mvn dependency:resolve
RUN mvn package

# Criando uma nova imagem para execução
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build target/*.jar app.jar

# Definindo o comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]