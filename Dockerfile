FROM openjdk:11
EXPOSE 8091

RUN curl -o kaddem-1.0.5.jar -L "http://192.168.1.22:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0.5/kaddem-1.0.5.jar"

ENTRYPOINT ["java", "-jar", "kaddem-1.0.5.jar"]