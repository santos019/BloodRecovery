FROM openjdk:11
EXPOSE 8004
VOLUME /tmp
ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY ocr-test-project-331005-faf99684c459.json credential.json
ENV GOOGLE_APPLICATION_CREDENTIALS credential.json
ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "/app.jar"]