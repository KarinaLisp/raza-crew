FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/raza-crew-0.0.1-SNAPSHOT-standalone.jar /raza-crew/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/raza-crew/app.jar"]
