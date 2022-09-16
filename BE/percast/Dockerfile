FROM openjdk:11
WORKDIR /var/jenkins_home/workspace/deploytest/BE/percast
VOLUME /tmp
#ARG JAR_FILE=build/libs/*.jar
#COPY {JAR_FILE} app.jar
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]