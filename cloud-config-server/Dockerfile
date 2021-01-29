FROM openjdk:11
ARG JAR_FILE=build/libs/cloud-config-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} config-server.jar
CMD ["java","-jar","/config-server.jar"]
