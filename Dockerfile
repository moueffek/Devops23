FROM openjdk:11
EXPOSE 8089

RUN curl -o kaddem-1.0.11.jar -L "http://192.168.1.23:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0.12/kaddem-1.0.12.jar"

ENTRYPOINT ["java", "-jar", "kaddem-1.0.12.jar"]