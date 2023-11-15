FROM openjdk:11
EXPOSE 8090
# Download the JAR file from the specified URL and rename it to kaddem-1.0.1.jar
RUN curl -o kaddem-1.0.2.jar -L "http://192.168.1.21:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0.2/kaddem-1.0.2.jar"

ENTRYPOINT ["java", "-jar", "kaddem-1.0.2.jar"]