FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /application
COPY --from=build /application/dependencies/ ./
COPY --from=build /application/spring-boot-loader/ ./
COPY --from=build /application/snapshot-dependencies/ ./
COPY --from=build /application/application/ ./

ENTRYPOINT ["java", "-cp", "/application", "org.springframework.boot.loader.launch.JarLauncher"]