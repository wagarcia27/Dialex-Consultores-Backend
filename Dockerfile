# Usa una imagen oficial de Java como base
FROM amazoncorretto:17-alpine-jdk

# Copia el archivo JAR generado en la imagen
COPY target/grupoEmpresarialGarcia-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java" , "-jar", "/app.jar"]