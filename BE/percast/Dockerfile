FROM openjdk:11
WORKDIR /var/jenkins_home/workspace/deploytest/BE/percast
RUN ./gradlew bootJar 
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]