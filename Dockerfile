FROM openjdk:17
LABEL authors="selma"
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]