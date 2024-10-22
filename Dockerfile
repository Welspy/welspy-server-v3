FROM openjdk:22
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "-Djava.net.preferIPv4Stack=true",  "/app.jar","-Duser.timezone=Asia/Seoul"]