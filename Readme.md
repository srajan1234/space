Project Overview

This project is built with Java 8 and utilizes an in-memory H2 database for simplicity. It includes the creation of two entities and the scheduling of two jobs that populate these entities with data at specified intervals. Additionally, the project provides CRUD operations and search functionalities accessible via a Swagger UI interface.
Prerequisites

    Java 8: Ensure Java 8 is installed on your system to run this project.

Database Setup

    H2 Database: We are using H2 as it is an in-memory database that does not require any setup. The database and its entities will be created automatically when you run the project.

Entities

When the project runs, the following entities will be created in the H2 database:

    CustomerSatellite
    Launcher

Scheduled Jobs

Two jobs are scheduled to run at specific intervals to fetch and save data into the database tables:

    CustomerSatelliteScheduler: This job fetches satellite information and runs every 10 seconds.
    LauncherServiceScheduler: This job fetches launcher information and runs every 5 seconds.

Application Structure

The project includes controllers, services, repositories, and DTOs to facilitate CRUD operations and search functionalities as per the requirements.
Accessing API Documentation

Once the project is running, you can access the Swagger documentation to explore the API endpoints, view schemas, and test CRUD operations:
  http://localhost:8080/swagger-ui/index.html
