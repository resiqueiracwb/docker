spring-boot-projects
java -jar build/libs/repo-0.0.1-SNAPSHOT.jar
docker build --rm -f "docker\Dockerfile" -t docker:v1 docker


docker build --rm -f "docker\Dockerfile" -t docker:v1 docker
docker run --rm -d -p  8080:8080  docker:v1

