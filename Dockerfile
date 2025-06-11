FROM maven:3.6.3-openjdk-17 AS build-app

COPY . /opt/
WORKDIR /opt
RUN mkdir -p /app-v1
RUN mvn clean -DskipTests
RUN mvn package -DskipTests

RUN ls
RUN mv target/*.jar /app/app-v1.jar
RUN ls /app


FROM maven:3.6.1-alpine

COPY --from=build-app /app/app-v1.jar /opt/
WORKDIR /opt
EXPOSE 3024
ENTRYPOINT [ "java", "-jar","app-v1.jar" ]