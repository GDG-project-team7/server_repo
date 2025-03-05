#dockerfile
FROM openjdk:17
ARG JAR_FILE=build/libs/hipple-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

