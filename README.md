RentPal – Rental Management System

RentPal is a full-stack rental management system designed to streamline rent tracking and complaint management between property owners and tenants.
The system is built using JavaFX (frontend), Spring Boot (backend), and MySQL (database).

Overview

RentPal provides a structured platform where:

Tenants can view and manage their rent payments

Owners can monitor tenant payment status

Complaints can be submitted and tracked efficiently

The system follows a layered architecture and REST-based communication between frontend and backend components.

Key Features
Authentication & Role Management

Secure login system

Role-based access (Owner / Tenant)

Payment Management

Record rent payments

Track payment status (Full / Partial / Overdue)

View payment history

Complaint Management

Submit complaints (Tenant)

View and update complaint status (Owner)

Status tracking (Open / In Progress / Resolved)

Technology Stack

Frontend

JavaFX

FXML

JavaFX CSS

Backend

Spring Boot

Spring Web (REST APIs)

Spring Data JPA / JDBC

Maven

Database

MySQL

MySQL Connector/J

System Architecture
JavaFX Frontend
        ↓ REST API
Spring Boot Backend
(Controller → Service → Repository)
        ↓ JDBC
MySQL Database

The architecture follows a standard three-layer design:

Controller Layer – Handles HTTP requests

Service Layer – Business logic

Repository Layer – Database interaction

Database Design
Users

id

name

role (OWNER / TENANT)

password

Payments

id

tenant_id

amount

payment_date

status (FULL / PARTIAL / OVERDUE)

Complaints

id

tenant_id

description

status (OPEN / IN_PROGRESS / RESOLVED)

Setup & Installation
Prerequisites

Java 17+

Maven

MySQL Server

JavaFX SDK

Backend Setup

Clone the repository

Create a MySQL database named rentpal

Configure application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/rentpal
spring.datasource.username=your_username
spring.datasource.password=your_password

Run the backend:

mvn spring-boot:run
Frontend Setup

Open the JavaFX project

Configure backend base URL (if required)

Run the main JavaFX application class

Project Structure
rentpal/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   └── config/
│
├── frontend/
│   ├── fxml/
│   ├── controller/
│   └── css/
│
└── database/
Future Enhancements

Automated payment reminder system

Email/SMS notifications

Admin dashboard

Cloud deployment

Docker containerization
