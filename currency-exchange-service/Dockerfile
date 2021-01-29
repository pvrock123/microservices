FROM openjdk:11
ARG JAR_FILE=build/libs/currency-exchange-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} currency-exchange-service.jar
CMD ["java","-jar","/currency-exchange-service.jar"]
