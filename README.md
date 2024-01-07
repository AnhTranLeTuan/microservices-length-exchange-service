# Length Exchange Service for Cloud-Based Microservices with DevOps and Automation

## Description
A part of the cloud-based microservices with DevOps and automation project that include:
* Set up this microservice for port 8000
* Create sample data for the H2 relational database in data.sql file, configure the connection to the H2 database through the application.properties file, then design the annotation-based entity or class to map to database tables
* Implement Repository class that used Spring Data JPA to obtain services for interaction between class objects and database tables
* Build LengthExchangeServiceController that map URL request to the specific function, and retrieve information from URL to appropriate return data to users; implement logger to monitor the Controller's calls
* Create CircuitBreakerController, as well as add additional properties in application.properties for experimenting retry, circuit breaker and rate limiter to implement fault-tolerance and resilience
* Register this microservice for Eureka service registry at port 8761
* Set up Micrometer and OpenTelemetry to allow the Zipkin server to monitor and manage this microservice's metrics, logs, and traces
