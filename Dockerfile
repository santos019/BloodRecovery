FROM openjdk:11
EXPOSE 8001
VOLUME /tmp
ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "/app.jar"]
# ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.datasource.url=jdbc:mysql://host.docker.internal:3306/mainDB"]
