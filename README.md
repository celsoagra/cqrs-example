# CQRS Example

This is my first application based on CQRS architecture. The example is focused on add and retrieve messages.

## Technologies

* Spring boot (2.3.0)
* H2 database (1.4.200)
* Nitrite Database (3.4.1)
* Apache Kafka (2.5.0)

## Architecture

![architecture](doc/cqrs_architecture.svg "Architecture")

## Configuring

* First, configure [Apache Kafka](https://kafka.apache.org/)

## Testing

#### POST Method

    curl -X POST -F 'message=String' http://localhost:8080/backend/message

#### GET Method
    curl -X GET http://localhost:8080/backend/message

