# aws-beanstalk-blog-workshop

## Prerequisites

Before you start, ensure you have met the following requirements:

- **Java**: JDK 17 or higher

## How to Start the Application

To start the application, follow these steps:

1. Open your terminal.
2. Navigate to the project directory.
3. Run the application using Maven:

```bash
mvn spring-boot:run
```

This command will start the Spring Boot application on the configured port.

## How to Package the Application into a JAR File

To package your Spring Boot application into a JAR file, follow these instructions:

1. Open your terminal.
2. Navigate to the project directory where your `pom.xml` is located.
3. Run the following Maven command:

```bash
mvn clean package
```

This command will clean the target directory, compile your code, and package it into a JAR file.
After successful packaging, you'll find the JAR file in the `target` directory of your project.
