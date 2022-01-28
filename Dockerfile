FROM openjdk:16-alpine
ADD /target/WebServ-0.0.1-SNAPSHOT.war webserv.war
COPY src/main/resources src/main/resources
EXPOSE 9991
ENTRYPOINT ["java", "-jar", "webserv.war"]