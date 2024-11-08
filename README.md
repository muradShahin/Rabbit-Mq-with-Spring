RabbitMQ with Spring Boot
This project demonstrates how to build a Spring Boot application that communicates with RabbitMQ for message handling. The application is designed to send messages in JSON format using the Jackson2JsonMessageConverter.

Prerequisites
To run this project, you need:

Docker installed on your machine
Java 11 or higher
Maven or an IDE that supports Maven
Getting Started
1. Pulling the RabbitMQ Docker Image
To get started with RabbitMQ, pull the Docker image that includes management tools:

bash
Copy code
docker pull rabbitmq:3.9.11-management-alpine
This image provides RabbitMQ version 3.9.11 with a lightweight Alpine base and the RabbitMQ management plugin pre-installed.

2. Running the RabbitMQ Docker Image
Start a RabbitMQ container using the following command:

bash
Copy code
docker run -p 5672:5672 -p 15672:15672 rabbitmq:3.9.11-management-alpine
5672: This is the default port for RabbitMQ messaging.
15672: This port allows access to the RabbitMQ Management Console, which you can access at http://localhost:15672.
3. Jackson2JsonMessageConverter
In this application, I used the Jackson2JsonMessageConverter to convert Java objects into JSON format and vice versa. This converter enables the application to send and receive messages in JSON format (application/json) by serializing the data as JSON. This makes the messages easily readable and compatible with various applications that use JSON as a data format.

The Jackson2JsonMessageConverter is configured in the application to handle all RabbitMQ message conversions, ensuring consistent and efficient data handling.

Running the Application
Once RabbitMQ is running, you can start the Spring Boot application using:

bash
Copy code
mvn spring-boot:run
Or by running the application from your preferred IDE.

Explore the Code
For detailed code, setup instructions, and implementation, visit the GitHub repository.

Additional Resources
RabbitMQ Official Documentation
Spring AMQP Documentation
