<h1 align="center"> Spring Boot Full Stack Application </h1> <br>
<p align="center" display="flex" flex-direction="row">
    <img alt="Java" title="Java" src="https://github.com/Isaac-Whiz/Full-Stack-Spring-Boot-Application/assets/95527627/5564af35-d3ed-4aa5-8bca-edfd93f54081" width="300">    
    <img alt="React" title="React" src="https://github.com/Isaac-Whiz/Full-Stack-Spring-Boot-Application/assets/95527627/37055c5e-7187-4798-9a92-41895a15a9d9" width="300" >
 </p>

<p align="center">
  Built with Java & React
</p>

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Built With](#built-with)
- [Feedback](#feedback)
- [Credits](#credits)


## Introduction
Crafted with love, the Spring Boot Full Stack Appication is a secure Entrepise Resource Planning system the simplfies the task of managing human resources in an institution. 
Paywork, printing, reprinting, to collect and correct misforms on user collected information, the lookup for the users and eventually deleting them by the archeivers. However this application simplifies the creation, deletion, update and reading resources with the system. 

**Accessible through the web.**

<p align="center">
  <img src = "https://github.com/Isaac-Whiz/Full-Stack-Spring-Boot-Application/assets/95527627/99c0b820-bfe0-4bec-986f-a44be19076ee" width=800>
</p>

## Features

A few of the things you can do with the application:

* View all saved persons.
* Update person's information.
* Create a new entry.
* Delete a person.
* And also authenticate or register with the system.
  

## Built With
### Frontend
- [React](https://www.w3schools.com/whatis/whatis_react.asp)
  
  This is a JavaScript library created by Facebook, a User Interface (UI) library and a tool for building UI components.
  This was used to create a number of components on the interface viz the buttons, drawers, and maniplating a couple of CSS properties listed but not limited to color, fonts, directions, sizes and many others.
- [Vite](https://vitejs.dev/guide/)
  
  Vite (French word for "quick", pronounced /vit/, like "veet") is a build tool that aims to provide a faster and leaner development experience for modern web projects. It consists of two major parts;
  A dev server that provides rich feature enhancements over native ES modules, for example extremely fast Hot Module Replacement (HMR).
  A build command that bundles your code with Rollup, pre-configured to output highly optimized static assets for production. This was used to provide ready servers for the frontend react development with 
  faster loading and automatic changes reflections.
- [Chakra templates](isaacwhiz/whiz-react14)

  This was used to claim different templates like predesigned buttons, drawers, navigation views and extra.
  
### Backend
- [Java](https://www.java.com/en/)
  
  This is a general purpose, strongly typed, and object oriented programming languages used for creating stand alone and servelets. This was used to create the base (stack) of the application simply creating
  the models to provided the foundation for application construction.
- [Spring Boot](https://spring.io/projects/spring-boot)
  
  This is an extension of the Spring framework, Java annotation and dependency injection framework that provides a number of different applications in form of dependencies injectable into a basic Java 
  application for functionality enchancements and faster development with simple configurations.
  Some of its used applications in this project are described below;
    * [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
      
      This simply stands for Java Database Connectivity, an application / dependency that provides connectivity and interaction with the database through writing [SQL](https://www.w3schools.com/sql/) 
      statements in Java code.
    * [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
      
      This is stands for Java Persistance Api which is an application with in Spring Boot that enables and manages interaction with the database through writing english-like statements using [Hibernate](https://hibernate.org/) in the background for data persistance.
    * Spring Web
      
      This enables the creation of REST application as its the case with this application and uses Tomcat as the embedded web service for loading the Json / Xml at the given endpoint of the application.
    * [JUnit Jupiter](https://docs.spring.io/spring-framework/reference/testing/annotations/integration-junit-jupiter.html)

      This is a testing class used in the application for writing unit tests. Checking different methods for example updating, deleting, creating and reading entities.
    * [DataFaker](https://www.datafaker.net/documentation/getting-started/)
      
      This is a Java (and Ruby) maven repository used to porvide fake data for new applications majorly used for writing tests providing data about different entities like persons, 
      vehicles, addresses and locations and many others.
    * [Test Containers](https://testcontainers.com/)
      
      This is an open source framewok that provides isolated, throwaway and light weigth instances of different applications like databases, web browers or anyother than runns in 
      containers for running tests. This was used for running the test individual / unit tests.
    * [Flyway](https://flywaydb.org/)

      This is a database migration tool which simplifies the taask of applying database modifications other than the tedious process of backing up, recreation and restoration of the
      database records.
    * [Postgres](https://www.postgresql.org/)
      
      This is a database management system which supervises relational databases and operations performed. This is the backbone of the application serving as the repository of the 
      records saved.
    * [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
      
      This is a library that provides annotations used to generate boilerplate code, simplifying the tedious tasks like creating toString methods, constructors, hashCode methods and 
      many others.
    * [Spring Security](https://spring.io/projects/spring-security)
      
      This is a Java library used to secure the application endpoints enabling the installation of different authentication methods lik basic authentication, name and password 
      authentication, token based authentication and many others. In specificity, [Json Web Token](https://jwt.io/) was used to taransfer the authentication credentials esnuring safety, 
      integrity and validity.
### Plugins
   * [Surefire](https://maven.apache.org/surefire/maven-surefire-plugin/)

     This is a Maven plugin used to execute intergration tests which involved the interoperatability of different parts of the application.
   * [Maven](https://maven.apache.org/)

     This is a Java application build tool used to construct executable <code>.war</code> or <code>.jar</code> files for distribution.
   * [Jib](https://cloud.google.com/blog/products/application-development/introducing-jib-build-java-docker-images-better)

     This is a Docker build tool used to automate the containerization and deployment of the docker image with no need of writing docker files for the application.     
### DevOps
   * [Git](https://github.com/)
     
     This is an open source collaboration tool that enables developers to contribute on a given project hosted on a remote repository on different platforms like Github, GitLab and many 
     others. This is incorporated into an application locally which monitors changes and makes updates, it also serves different functionalities like continous intergration and delivery 
     of code through the workflows.
   * [AWS](https://aws.amazon.com/)
     
     This acromny stands for Amazon Web Services which is a software as a platform providing a couple of different products and some of the used ones in the application are given below;
   - EBS

     This stands for Elastic Bean Stalk a service that manages the entire deployment process of the application having no need of much configuration as it requires a few clikcs to get 
     the application up and running.
   - ECS

       This stands for Elastic Container Service, which is also an Amazon service used to enable spinning containers in the AWS infrastructure.       
   - RDS

      This represents Relational Database System which is an Amazon service for simple setting up and operating the relational databases. It provides support (drivers) for different
      database management systems namely Postgres (used), MySQL and many others.  
   - EC2

     This is an other Amazon service that provides auto scable compute services running virtually with the ECS to ensure robust and effective traffic manageent.       
   * [Docker](https://docs.docker.com/desktop/install/windows-install/)

     This is a containerisation technology that enables the packaging of application into docker images onto which platform indepent containers can ne run.
     
   
## Feedback

Choice entirely to send us feedback on [Twitter / X](https://x.com/IsaacWavamuno?s=09), [Mail](ssekajjawavamuno@gmail.com) else [file an issue](https://github.com/Isaac-Whiz/Full-Stack-Spring-Boot-Application/issues).

## Installation

If interested in exploring the flow and usage of the applicatio, can be accessed from [here]().
However, while wishing to run it locally, follow the below steps;
- Milestone 1
  Install Postgres starting from version 15.0++.
  Install Docker on your machine.
- Milestone 2
  Open the CMD and run <code>docker pull postgres</code> to pull the postgres image from docker.
  Run <code>docker pull isaacwhiz/whiz-api</code> to pull the Whiz Api image from docker.
  Run <code>docker pull isaacwhiz/whiz-react14</code> to pull the frontend image from docker.
  Open a file editor and paste the below configuration (keep the alignment as is) then save the file as a <code>docker-compose.yaml</code> file.
  
  <code>
services:
  db:
    container_name: post
    image: postgres:15.4
    environment:
      POSTGRES_USER: whiz
      POSTGRES_PASSWORD: isaacwhiz
      PGDATA: /data/full_stack
    volumes:
        - db:/data/full_stack
    ports:
        - "2001:5432"
    networks:
      - db
    restart: unless-stopped

  isaacwhiz-api:
   container_name: whiz-api
   image: isaacwhiz/whiz-api
   environment:
     SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/full_stack
   ports:
     - "8088:8080"
   networks:
     - db
   depends_on:
     - db
   restart: unless-stopped
   command:
     - --spring.datasource.url=jdbc:postgresql://db:5432/full_stack

  isaacwhiz-react:
    container_name: frontend
    image: isaacwhiz/whiz-react14
    build:
      context: frontend/react
      args:
        api_base_url: http://localhost:8088
    ports:
      - "4000:5173"
    depends_on:
      - isaacwhiz-api
    restart: unless-stopped

networks:
  db:
    driver: bridge
volumes:
    db:
  </code>

  Note: If your configuration is distorted, use the file [here](https://github.com/Isaac-Whiz/Full-Stack-Spring-Boot-Application/blob/main/docker-compose.yml) and make a few adjustments to match the above.
  Note: You can save the above file as <code>.yaml</code> or <code>.yml</code>.
  Locate where you saved the above <code>.yaml</code> following codes.
  <code>docker-compose up</code>
  If you saved yor docker file with a different name then run <code>docker-compose -f custom-compose-file.yml up</code>
  Navigate to the web browser and run <code>localhost:4000</code> in the search bar and press enter.
  Viola! Your app is up and running.
  
## Credits
- [Amigoscode](https://www.amigoscode.com/) as the mentor.
- [AWS](https://aws.amazon.com/) for free tier services.
- Emojis are taken from [here](https://github.com/arvida/emoji-cheat-sheet.com).

