FROM openjdk:11
ADD target/DarajaAPI-0.0.1-SNAPSHOT.jar DarajaAPI.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "DarajaAPI.jar"]