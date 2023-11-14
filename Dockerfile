FROM openjdk:11
EXPOSE 8089
# Download the JAR file from the specified URL and rename it to kaddem-1.0.1.jar
RUN curl -o kaddem-1.0.1.jar -L "http://192.168.8.190:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0.1/kaddem-1.0.1.jar"

ENTRYPOINT ["java", "-jar", "kaddem-1.0.1.jar"]