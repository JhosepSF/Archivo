#Definiendo el jdk
FROM eclipse-temurin:17-jdk

#El puerto donde corre esta shit es
EXPOSE 8080

#El directorio del contenedor
WORKDIR /root

#Copiar y pegar archivos en el contenedor
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

#Descargar dependencias
RUN ./mvnw dependency:go-offline

#Copiar el codigo fuente 
COPY ./src /root/src

#Contruccion de la aplicacion
RUN ./mvnw clean install -DskipTests

#Levantar nuestra aplicacion cuando el contenedor inicie
ENTRYPOINT [ "java", "-jar", "/root/target/archivo-0.0.1-SNAPSHOT.jar" ]