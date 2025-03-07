# Usa una imagen oficial de Java como base
FROM eclipse-temurin:17-jdk

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado en la imagen
COPY target/*.jar app.jar

# Expone el puerto (Render usará la variable de entorno PORT)
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]