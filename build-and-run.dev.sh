#!/bin/bash

# Generar el .jar para el config-server
echo "Generando el JAR para config-server..."
cd ./microservice.config || exit
mvn clean package -DskipTests || { echo "Error generando el JAR para config-server"; exit 1; }
cd .. || exit

# Generar el .jar para el eureka-server
echo "Generando el JAR para eureka-server..."
cd ./microservice.eureka || exit
mvn clean package -DskipTests || { echo "Error generando el JAR para eureka-server"; exit 1; }
cd .. || exit

# Construir y levantar los contenedores con Docker Compose
echo "Construyendo y levantando los contenedores..."
docker-compose -f docker-compose.dev.yml up --build -d