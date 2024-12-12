# Usar una imagen base de Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el JAR generado al contenedor
COPY target/tu-api-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que usa tu aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]