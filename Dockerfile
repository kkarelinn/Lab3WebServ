FROM openjdk:16-alpine
ADD /target/WebServ-0.0.1-SNAPSHOT.war start.war
EXPOSE 9991
ENTRYPOINT ["java", "-jar", "start.war"]