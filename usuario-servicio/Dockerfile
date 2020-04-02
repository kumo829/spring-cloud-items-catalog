FROM openjdk:12-alpine
VOLUME /tmp
ADD ./build/libs/usuario-servicio-0.0.1-SNAPSHOT.jar servicio-usuarios.jar
ENTRYPOINT ["java", "-jar", "/servicio-usuarios.jar"]