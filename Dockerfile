#imagen base de java
FROM openjdk:21-jdk-slim

#directorio de la app
WORKDIR /app

#Copiar el archivo JAR generado en el contenedor
COPY target/crud-0.0.1-SNAPSHOT.jar app.jar

#exponer el puerto que usa la app
EXPOSE 9055

#Comando para ejecutar la aplicacion
ENTRYPOINT ["java","-jar", "app.jar"]