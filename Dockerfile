# Etapa 1: Construcción del JAR
FROM maven:3.8.6-eclipse-temurin-17 AS builder

# Define el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY . .

# Ejecuta Maven para compilar y generar el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con el JAR generado
FROM amazoncorretto:17-alpine-jdk

# Define el directorio de trabajo
WORKDIR /app

# Copia el JAR generado en la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
