FROM openjdk:22
LABEL authors="selma"
ADD target/demo-0.0.1-SNAPSHOT.jar doowaste.jar
ENTRYPOINT ["java", "-jar" ,"doowaste.jar"]