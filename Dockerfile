FROM eclipse-temurin:17-jdk
COPY target/archivo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]