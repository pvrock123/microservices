FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=build/libs/limits-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
CMD ["java","-jar","/app.jar"]
