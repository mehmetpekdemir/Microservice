# Microservice Project

### What are microservices ? 

Microservices - also known as the microservice architecture - is an architectural style that structures an application as a collection of services that are
 - Highly maintainable and testable
 - Loosely coupled
 - Independently deployable
 - Organized around business capabilities
 - Owned by a small team
 
The microservice architecture enables the rapid, frequent and reliable delivery of large, complex applications. It also enables an organization to evolve its technology stack.

Also see : https://microservices.io/

### Tech Stack 
 - Java 11
 - Spring Framework(Spring Boot , Spring Cloud , Spring Data)
 - REST-API
 - API-Gateway
 - Config-server
 - Eureka-server & Eureka-client
 - Admin-server
 - Zipkin-server
 - Netflix-Hystrix
 - Cassandra
 - Elasticsearch
 - MySQL
 - RabbitMQ
 - Docker
 - Lombok

### Design 
![DesignPhoto](https://github.com/mehmetpekdemir/Microservice/blob/develop/docs/Design.png)

### Json

- api/v1/account
```json
  {
     "firstName":"Mehmet",
     "lastName":"Pekdemir",
     "username":"MehmetPekdemir",
     "email":"mehmetpekdemir06@hotmail.com",
     "password":"Test123+"
  }
```
- api/v1/ticket
```json
  {
     "description":"Test Description",
     "notes":"Test notes",
     "assignee":"9cb66eca-78d4-4c6b-9d13-a03e239cde82",
     "priorityType":"HIGH",
     "ticketStatus":"OPEN",
     "ticketDate":"2017-01-01"
  }
```

### Requirements

For building and running the application you need:
- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or newer . 
- [Maven](https://maven.apache.org)
- [Docker](https://www.docker.com/)
- [Lombok](https://projectlombok.org/)

### Build & Run

```
  docker-compose -f "YOUR_LOCATION\docs\docker-compose.yml" up -d 
```

```
  mvn clean install 
```

```
  CREATE KEYSPACE springcloud WITH replication = {'class':'SimpleStrategy','replication_factor':3};
```

```
  CREATE SCHEMA `microserviceapp`
```

### Ports
```
  Config server port : http://localhost:8888
  
  Eureka server port : http://localhost:8500
  
  Zipkin server port : http://localhost:9411
  
  Gateway port : http://localhost:8088
  
  HystrixDasboard port: http://localhost:8080
  
  Admin server : http://localhost:8508
  
  Account service : http://localhost:8501
  
  Ticket service : http://localhost:8502
  
  Notification service : http://localhost:8503
  
```
