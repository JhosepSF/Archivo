# Definiendo el jdk
FROM eclipse-temurin:17-jdk

# Instalar netcat
RUN apt-get update && apt-get install -y netcat

# El puerto donde corre esta aplicación
EXPOSE 8080

# El directorio del contenedor
WORKDIR /root

# Copiar y pegar archivos en el contenedor
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# Dar permisos de ejecución a mvnw
RUN chmod +x /root/mvnw

# Descargar dependencias
RUN ./mvnw dependency:go-offline

# Copiar el código fuente 
COPY ./src /root/src

# Construcción de la aplicación
RUN ./mvnw clean install -DskipTests

# Levantar nuestra aplicación cuando el contenedor inicie
ENTRYPOINT [ "sh", "-c", "while ! nc -z mysql 3306; do sleep 1; done; java -jar /root/target/archivo-0.0.1-SNAPSHOT.jar" ]
