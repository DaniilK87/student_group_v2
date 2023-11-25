FROM openjdk:11
MAINTAINER DaniilK
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} student-app.jar
ENTRYPOINT ["java", "-jar", "/student-app.jar"]