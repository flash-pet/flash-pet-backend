# select parent image
FROM maven:3.6.3-jdk-11-openj9
# set port
EXPOSE 8080/tcp
# copy the source tree and the pom.xml to our new container
COPY ./ ./
# package our application code
RUN mvn clean install
# set the startup command to execute the jar
CMD ["java", "-jar", "api/target/api-0.0.1-SNAPSHOT.jar"]
