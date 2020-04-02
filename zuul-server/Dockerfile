FROM openjdk:12-alpine
VOLUME /tmp
EXPOSE 8090
ADD ./build/libs/zuul-server-0.0.1-SNAPSHOT.jar zuul-server.jar
ENTRYPOINT ["java", "-jar", "/zuul-server.jar"]