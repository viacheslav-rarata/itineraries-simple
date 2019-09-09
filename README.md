# Coding Challenge "Itineraries"

### Project structure
- discovery-server: Eureka Discovery and Registry server.
- producer-service: Eureka Client that produce data.
- producer-service: Eureka Client that consume data.

#### Technologies
- Java 8
- Spring Boot 2.1.7
- Spring Cloud
- Swagger2
- Lombok
- neo4j

### Swagger endpoints
 - http://localhost:8100/api/swagger-ui.html Swagger for data producer
 - http://localhost:8200/api/swagger-ui.html Swagger for data consumer 

### Build and run
For build project run:
```sh
$ mvn clean package
$ docker build -t itineraries-simple/discovery-erver:1.0 ./discovery-server
$ docker build -t itineraries-simple/consumer-service:1.0 ./consumer-service
$ docker build -t itineraries-simple/producer-service:1.0 ./producer-service
```
For run project into docker run:
```sh
$ docker-compose up --no-start
```
