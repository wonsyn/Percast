FROM openjdk:11
WORKDIR /var/jenkins_home/workspace/deploytest/BE/percast
#VOLUME /tmp
#ARG JAR_FILE=build/libs/*.jar
#COPY {JAR_FILE} app.jar
RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
COPY build/libs/percast-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]