# spring-microservices
# Microservices Spring Boot Project

Este proyecto tiene como objetivo poner en práctica la arquitectura de microservicios utilizando Spring Boot. Implementa varios servicios intercomunicados, con un enfoque en la configuración de un entorno de desarrollo activo y la dockerización de varios componentes para facilitar su ejecución y pruebas.

## Descripción

El proyecto está compuesto por varios microservicios que trabajan juntos para demostrar una solución basada en Spring Boot:

- **Gateway**: Servicio que actúa como punto de entrada único para todos los otros microservicios, escuchando en el puerto `8080`.
- **Services**:
    - **Member Service**: Gestiona la información de los miembros dentro de las comunidades.
    - **Community Service**: Gestiona la información de las comunidades y sus relaciones con los miembros.
    - **Config Service**: Proporciona la configuración centralizada para los demás microservicios utilizando Spring Cloud Config.
    - **Eureka Service**: Servicio de descubrimiento de microservicios mediante Netflix Eureka.

El entorno de desarrollo está completamente configurado para trabajar con **Docker**. Los servicios de base de datos (PostgreSQL, MySQL), Eureka y Config están dockerizados y se pueden iniciar fácilmente mediante un script. Además, la configuración de Docker se incluye para facilitar el desarrollo, y se han implementado prácticas para pruebas locales simuladas en producción utilizando Kubernetes.

## Características

- **Dockerización de servicios**: Los servicios de PostgreSQL, MySQL, Eureka y Config están configurados para ejecutarse en contenedores Docker.
- **Spring Cloud Config**: Los servicios de configuración y descubrimiento se gestionan mediante Spring Cloud Config y Eureka.
- **Gateway API**: El Gateway expone un único endpoint para interactuar con los servicios de comunidad y miembros.
- **Entorno de desarrollo**: Configuración para desarrollo activo, donde todos los servicios están integrados y disponibles para pruebas locales.

## Instrucciones de configuración y uso

1. **Clonar el repositorio**:
```bash
git clone https://github.com/dianderas/spring-microservices.git
cd spring-microservices
```

2. **Ejecutar el entorno de desarrollo**

Para iniciar los servicios de eureka, config service, mysql y postgress para que este disponibles para el entorno de desarrollo (dockerizado), ejecuta el siguiente script:

```bash
./build-and-run.dev.sh
```
**3. Probar la conectividad**

Una vez que los servicios estén en funcionamiento, puedes probar la conectividad mediante el siguiente endpoint en el Gateway:

```bash
http://localhost:8080/api/communities/1/members
```
Esto devolverá una respuesta con información sobre la comunidad y sus miembros, por ejemplo:

```
{
    "name": "Comunidad A",
    "description": "Descripción de la comunidad A",
    "members": [
        {
            "id": 1,
            "userId": 1,
            "customNickname": "CoolGamer",
            "note": "Leader of the community",
            "role": "ADMIN",
            "communityId": 1
        },
        {
            "id": 4,
            "userId": 4,
            "customNickname": "MovieBuff",
            "note": "New member with high engagement",
            "role": "MEMBER",
            "communityId": 1
        }
    ]
}
```

## Tareas Pendientes

A continuación se describen las tareas pendientes para completar y mejorar la infraestructura del proyecto:

- **Implementar seguridad OAuth2**  
  Configurar e implementar seguridad con OAuth2 para asegurar los servicios y permitir el control de acceso basado en roles.

- **Implementar Apacha Kafka para comunicacion Asincrona**  
  Crear y configurar un servicio utilizando Spring WebFlux para gestionar peticiones de manera reactiva y no bloqueante.

- **Implementar un servicio usando Spring WebFlux**  
  Crear y configurar un servicio utilizando Spring WebFlux para gestionar peticiones de manera reactiva y no bloqueante.

- **Configuración para pruebas de producción simuladas en local con Kubernetes**  
  Configurar un entorno de Kubernetes local para simular un entorno de producción y probar la infraestructura de microservicios.

- **Configuración CI/CD para despliegue a producción con Jenkins**  
  Implementar una pipeline CI/CD con Jenkins para automatizar el proceso de despliegue a producción.
