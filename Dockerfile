FROM openjdk:11
EXPOSE 8089
COPY ./target/kaddem-1.0.1.jar kaddem-1.0.1.jar
# Set the image name and tag based on the environment variable
# ARG IMAGE_NAME
# LABEL image=$IMAGE_NAME
ENTRYPOINT ["java","-jar","/kaddem-1.0.1.jar"]