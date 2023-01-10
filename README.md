# store-comparator Project

Store comparator service is used for store comparison between 2 games stores.
It offers 2 REST endpoint for saving and deleting games which we want to comapre.
It also offers a REST endpoint to compare all the games which we have saved.

Api documentation with OpenAPI can be found on the url: /q/swagger-ui

To run the project locally in docker run commands:

## Run local database

```shell script
docker run -it --rm=true --name quarkus_test -e POSTGRES_USER=quarkus_test -e POSTGRES_PASSWORD=quarkus_test -e POSTGRES_DB=quarkus_test -p 5432:5432 postgres:14.1
```

## Docker build

```shell script
docker build -f Dockerfile.jvm -docker push tjasad/rso-steam-parsert tjasad/rso-store-comparator .
```

## Docker run

```shell script
docker run -i --rm -p 8083:8083 tjasad/rso-store-comparator
```

## Dockerhub link

https://hub.docker.com/repository/docker/tjasad/rso-store-comparator

## OpenAPI

http://localhost:8083/q/swagger-ui/
http://localhost:8083/openapi/

There is also a deployment file for k8s present which can be used for kubernetes deployment.

