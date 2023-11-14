FROM openjdk:11-jdk
EXPOSE 8089
ADD ./target/KaddemProject-1.0.jar KaddemProject-1.0.jar
ENTRYPOINT ["java","-jar","/KaddemProject-1.0.jar"]
