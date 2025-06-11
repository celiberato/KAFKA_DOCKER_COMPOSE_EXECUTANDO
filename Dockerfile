# Usando uma imagem base do OpenJDK
FROM openjdk:17-jdk-alpine

# Definindo o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiando o arquivo JAR para o contêiner
COPY target/app-v1.jar app.jar

# Definindo o comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]