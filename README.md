# demoservices


## Description

This is a demo project used to implement a distributed microservices architecture.

## Architecture

- Gateway / Load Balancer
- 3x Microservices (Fraud, Customer, and Notification)
- 1x Database (Postgres)
- 1x Message Broker (RabbitMQ)
- 1x Eureka Server (Service Discovery)
- `See under /Documentation for visual aid`

## How to run

- Have `Docker` running
- Run `docker-compose up` in the root directory
- Wait for all services to start
- Navigate to `http://localhost:8761` to see the Eureka dashboard
- Zipkin is available at `http://localhost:9411`
- RabbitMQ is available at `http://localhost:15672`
- The Gateway is available at `http://localhost:8083`

## Endpoint Documentation

- POST /api/v1/customers
  - Example Request Body:
    ```json
    {
      "firstName": "John",
      "lastName": "Smith",
      "email": "john.smith@hotmail.com"
    }
    ```

## How to Use:

- Create a customer using the endpoint above at: `http://localhost:8083/api/v1/customers`
- Check the request propagation in Zipkin at: `http://localhost:9411/zipkin/`