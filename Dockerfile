FROM openjdk:11
ADD target/DarajaAPI.jar DarajaAPI.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "DarajaAPI.jar"]