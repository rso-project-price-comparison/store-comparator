# store-comparator Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Run local database
```shell script
docker run -it --rm=true --name quarkus_test -e POSTGRES_USER=quarkus_test -e POSTGRES_PASSWORD=quarkus_test -e POSTGRES_DB=quarkus_test -p 5432:5432 postgres:14.1
```

## Docker build
```shell script
docker build -f Dockerfile.jvm -t tjasad/rso-store-comparator .
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
