FROM openjdk:11
EXPOSE 8089
COPY ./target/kaddem-0.0.1-SNAPSHOT.jar kaddem-0.0.1-SNAPSHOT.jar
# Set the image name and tag based on the environment variable
# ARG IMAGE_NAME
# LABEL image=$IMAGE_NAME
ENTRYPOINT ["java","-jar","/kaddem-0.0.1-SNAPSHOT.jar"]