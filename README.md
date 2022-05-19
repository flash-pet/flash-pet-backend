# Flash Pet Backend 

Flash Pet is a project based on Java 11 and Spring Boot.

## About

In this project, We have modules and each module has its responsibility.

Modules structure

- Api
- Security
- Service
- Infrastructure
- Domain
- Test 

## Technology 
- Java 11
- Spring Boot 2.6.7
- Docker

## How to run 

You can run this project without a big configuration using only Docker 

To run this project using docker you will need follow this steps.

- Install Docker
- Go to the src folder 
- Run these commands

```bash
docker build .
```
```bash
docker run -d --name flash-pet-backend -p 8080:8080
```
After these command you can to consume local services but if you like to debug this project, you will need to install Java 11

To install java 11 in linux, you can try to run this command

```bash
sudo apt-get install openjdk-11-jdk
``` 
## External Services

- AWS Elastic Beanstalk 
- Amazon OpenSearch
- Amazon DynamoDB
