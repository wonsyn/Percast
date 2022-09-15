FROM openjdk:11 AS builder
WORKDIR /var/jenkins_home/workspace/deploytest/BE/percast
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar
#ARG JAR_FILE=build/libs/*.jar
FROM openjdk:11
COPY --from=builder build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]