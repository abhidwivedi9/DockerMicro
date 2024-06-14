FROM eclipse-temurin:21-jdk
VOLUME /tmp
COPY target/eurekademo-0.0.1-SNAPSHOT.jar eurekaserver.jar
ENTRYPOINT ["java", "-jar", "/eurekaserver.jar"]