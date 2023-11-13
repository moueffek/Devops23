# Maven image
FROM maven:3.8.4-openjdk-11-slim
# Set the working directory in the container
WORKDIR /usr/src/app
# ARG to receive branch as a build argument
ARG GIT_BRANCH
# Clone a specific Git branch
RUN git clone --branch $GIT_BRANCH --single-branch https://github.com/moueffek/Devops23.git .
# Clean project with Maven
RUN mvn clean
# Compile project with Maven
RUN mvn compile
# MVN Sonarqube
#RUN mvn sonar:sonar -Dsonar.login=squ_78935e7022d208c38ce83a2a5ae88d9baaa3ca87
# Test project with Maven
#RUN mvn test
# Deploy project with Nexus
#RUN mvn deploy -DskipTests
