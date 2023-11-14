FROM openjdk:11
EXPOSE 8089

RUN curl -o kaddem-1.0.3.jar -L "http://192.168.1.21:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0.3/kaddem-1.0.3.jar"

ENTRYPOINT ["java", "-jar", "kaddem-1.0.3.jar"]