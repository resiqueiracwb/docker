FROM adoptopenjdk/openjdk12:latest

# add directly the jar
ADD build/libs/*.jar /app.jar

# to create a modification date
RUN sh -c 'touch /app.jar'

# creates a mount point
VOLUME /tmp

CMD ["java", "-jar", "/app.jar"]
#CMD ["java", "-jar", "/app.jar", "--spring.profiles.active=prod"]

EXPOSE 8081
