FROM openjdk:11
ARG JAR_FILE=build/libs/currency-converter-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} currency-converter-service.jar
CMD ["java","-jar","/currency-converter-service.jar"]
