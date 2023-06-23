FROM openjdk:17-jdk-alpine AS builder
WORKDIR application
ARG JAR_FILE=target/employee-service.jar
COPY ${JAR_FILE} employee-service.jar
RUN java -Djarmode=layertools -jar employee-service.jar extract

FROM openjdk:17-jdk-alpine
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]