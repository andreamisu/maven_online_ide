# Online IDE

A load-balanced Eureka server Online compiler, made with Maven Springboot Microservices.

![Apache Maven](https://img.shields.io/badge/Apache%20Maven-brightgreen)
![Netflix Eureka](https://img.shields.io/badge/Netflix%20Eureka-red)
![Springboot](https://img.shields.io/badge/Springboot-orange)
![Angular](https://img.shields.io/badge/Angular-blue)
![Docker](https://img.shields.io/badge/Docker-informational)

## Overview

As TUM "Advanced Topics of Software Engineering", we created web application for online compiling Java and C files. 

## Microservices 

6 Microservices, made with Springboot + Maven, made up the whole infrastructure:

- Service Registry
	* Springboot Maven application to enable Netflix Eureka Services Discovery
- Project
	* Projects and Sourcefiles are managed thru a RestController interface.
	* PostgreSQL and H2 Database integration for data persistence.
- Dark Mode
	* Dark theme is exposed as external service, that can be hitted by simple HTTP calls.
	* .c source files as part of integration with an external Microcontroller can be found inside the folder
- Frontend
	* Wrappper for serving an Angular frontend interface
- Compiler
	* Core implementation of the compiler functionality
- Api Gateway
	* Main gateway that redirect users to the frontend interface, including management of security token validity 


## Features
- Main Capabilities:
	* CRUD operations on Projects entities, as Sourcefiles container, thru Angular interface
	* CRUD operations on Sourcefiles entities thru Angular interface

- Compiler: 
	* Java and C files support, including Stderr and Stdout from compilation.

## Install

- Dependencies:
    * JDK 15
    * Maven
    * Docker and Docker Compose 

You should create a Token inside your Github repo for the security token relay (https://docs.gitlab.com/ee/api/oauth2.html)
and write your own client_id and client_secret inside the application.yml in the API-GATEWAY folder.

## Usage

Execute ``mvn package`` inside each microservices maven folder.

you can use ``docker-compose up`` in the root, where the docker-compose.yml file is, to run everything.

## CI/CD

in the root, a Gitlab CI/CD job is already setup and working.
You can use that as base for your own CI/CD, just remember to initialize your own RSA public key on your Github profile.

## GG WP! 

for any enquire, question, whatever, write an issue i'll gladly take time to reply x
