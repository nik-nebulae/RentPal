🏠 RentPal
Smart Rental Management System

A full-stack rental management platform built with JavaFX, Spring Boot, and MySQL to simplify rent tracking and complaint handling for property owners and tenants.

✨ What RentPal Solves

Managing rental properties manually leads to:

Missed rent tracking

Poor complaint visibility

No structured payment history

RentPal centralizes everything into one system.

🚀 Core Features

🔐 Role-Based Authentication
Separate dashboards for Owners and Tenants.

💰 Payment Tracking System

Record payments

Track Full / Partial / Overdue status

View payment history

🛠 Complaint Management

Tenants can raise complaints

Owners can update status

Track resolution progress

🏗 System Architecture
JavaFX UI  →  REST APIs  →  Spring Boot  →  MySQL

Architecture Pattern: Layered (Controller → Service → Repository)

This ensures:

Clean separation of concerns

Scalable backend design

Maintainable codebase

🛠 Tech Stack
Layer	Technology
Frontend	JavaFX (FXML + CSS)
Backend	Spring Boot (REST APIs)
Database	MySQL
ORM / Access	JDBC / Spring Data JPA
Build Tool	Maven
🗄 Database Schema

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

status

Complaints

id

tenant_id

description

status

⚙️ How to Run
1️⃣ Backend

Configure MySQL database rentpal

Update application.properties

Run:

mvn spring-boot:run
2️⃣ Frontend

Open JavaFX project

Run main application class

📌 Future Roadmap

Automated payment reminders

Email notifications

Admin panel

Cloud deployment
