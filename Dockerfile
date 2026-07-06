FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY out/artifacts/tarefator_cli_jar/tarefator-cli.jar /app/app.jar

RUN mkdir -p /src/main/data

CMD ["java", "-jar", "app.jar"]