FROM openjdk:11
ARG JAR_FILE=build/libs/api-gatway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} api-gatway.jar
CMD ["java","-jar","/api-gatway.jar"]
