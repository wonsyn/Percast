FROM openjdk:11
WORKDIR /var/jenkins_home/workspace/deploytest/BE/percast
ARG JAR_FILE=build/libs/*.jar
ADD {JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]