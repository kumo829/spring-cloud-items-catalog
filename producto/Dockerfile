FROM openjdk:12-alpine
VOLUME /tmp
ADD ./build/libs/producto-0.0.1-SNAPSHOT.jar servicio-productos.jar
ENTRYPOINT ["java", "-jar", "/servicio-productos.jar"]
