FROM openjdk:11.0.1-jre
VOLUME /tmp
COPY target/airport-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080