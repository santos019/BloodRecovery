FROM arm32v7/adoptopenjdk:11-jre-hotspot
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]