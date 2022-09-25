# Simple REST API

## Summary
Simple REST API obtaining CRUD operations on cities with endpoints as defined in the OpenAPI specification.

## Techology
- Language: Java
- Framework: Spring Boot

## Endpoints (and logic)
Endpoints are defined in openapi.yaml

## Documentation
You can build and run app with IDE (run as Java app) or you can do it in terminal.

### Build and run app
The Spring Boot application is located in the cities folder.
```sh
$ cd ./cities
```

Clear the target directory (if needed), build the project described by Maven POM file and install the resulting artifact (JAR) into your local Maven repository.
```sh
$ mvn clean install
```

Run the Spring Boot Application 
```sh
$ mvnw spring-boot:run
```


You can send requests to the REST service using Postman. 



