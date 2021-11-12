FROM openjdk:8
ADD target/bidv-service-1.0.3.jar bidv-service-1.0.3.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar","bidv-service-1.0.3.jar"]