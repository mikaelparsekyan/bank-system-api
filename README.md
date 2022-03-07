# bank-system-api
Bank system is project where members can register, save and withdraw money. 
It simulates basic ATM.

## Build Requirements
To run this application you need to have following software installed in your environment:

    Java 11
    Docker
    Docker Compose
   
## How to run the application?
1. Run `./gradlew build` for Linux(MacOS) or `gradlew.bat build` for Windows
2. Start application into docker environment using `docker-compose up` or do
 this by running all services in `application.yml`. Docker compose will take up `Kafka`, `Zookeeper` and `PostgreSQL`.
3. Checkout [Swagger API](localhost:8080/swagger-ui.html#/)
  

## Architecture
Project architecture diagram:
![diagram](./documentation/architecture_diagram.jpeg)

Single microservice architecture diagram:
![diagram](./documentation/single_microservice_diagram.jpeg)

UML diagram:
![diagram](./documentation/uml_diagram.jpeg)

### Microservices and their ports


|       Service name        | Port |
| --------------------------|:----:|
| api-gateway               | 8080 |
| authentication-service    | 8081 |
| member-service            | 8082 |
| event-service             | 8083 |


## Author
[Mikael Parsekyan](https://github.com/mikaelparsekyan)
