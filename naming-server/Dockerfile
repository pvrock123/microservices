FROM openjdk:11
ARG JAR_FILE=build/libs/naming-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} naming-server.jar
CMD ["java","-jar","/naming-server.jar"]
