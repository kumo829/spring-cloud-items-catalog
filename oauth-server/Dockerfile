FROM openjdk:12-alpine
VOLUME /tmp
EXPOSE 9100
ADD ./build/libs/oauth-server-0.0.1-SNAPSHOT.jar oauth-server.jar
ENTRYPOINT ["java", "-jar", "/oauth-server.jar"]