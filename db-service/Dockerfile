FROM openjdk:8
ADD target/db-service.jar db-service.jar
EXPOSE 8300
ENTRYPOINT ["java","-jar","db-service.jar"]