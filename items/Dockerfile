FROM openjdk:12-alpine
VOLUME /tmp
ADD ./build/libs/items-0.0.1-SNAPSHOT.jar servicio-items.jar
ENTRYPOINT ["java", "-jar", "/servicio-items.jar"]