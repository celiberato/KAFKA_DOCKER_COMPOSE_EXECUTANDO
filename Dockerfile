FROM maven:3.6.3-openjdk-16 AS build-app

COPY . /opt/
WORKDIR /opt
RUN mkdir -p /app
RUN mvn clean -DskipTests
RUN mvn package -DskipTests

RUN ls
RUN mv target/*.jar /app/app.jar
RUN ls /app


FROM maven:3.6.1-alpine

COPY --from=build-app /app/app.jar /opt/
WORKDIR /opt
EXPOSE 3024
ENTRYPOINT [ "java", "-jar","app.jar" ]