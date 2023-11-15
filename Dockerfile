FROM openjdk:11
EXPOSE 8090

RUN curl -o kaddem-1.0.4.jar -L "http://192.168.1.21:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0.4/kaddem-1.0.4.jar"

ENTRYPOINT ["java", "-jar", "kaddem-1.0.4.jar"]