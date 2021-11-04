FROM openjdk:11
EXPOSE 8000
VOLUME /tmp
ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYpoint ["java", "-jar", "/app.jar", "--spring.datasource.url=jdbc:mysql://host.docker.internal:3306/mainDB"]