FROM openjdk:8
ADD target/bidv-service-1.0.2.jar bidv-service-1.0.2.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar","bidv-service-1.0.2.jar"]