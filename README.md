Overview
Wellspring is a Spring Boot–based backend application designed for health and diet management.
The backend provides secure REST APIs for user authentication, BMI calculation, waist-risk analysis, diet plan generation, BMI progress tracking, and admin-level monitoring.

The project follows clean layered architecture and is built for learning, scalability, and real-world deployment.




Architecture

The backend follows a Layered Architecture:

Controller Layer – Handles HTTP requests and responses

Service Layer – Contains business logic (BMI, waist, diet logic)

Repository Layer – Handles database operations using Spring Data JPA

Security Layer – Manages authentication and authorization using Spring Security

This separation ensures maintainability, readability, and testability.




Security

Spring Security 6 is used

Basic Authentication (for learning purpose)

Role-based authorization

ROLE_USER – Normal users

ROLE_ADMIN – Admin users

BCrypt password encryption

CORS enabled to allow frontend (JavaScript / Netlify)

⚠ JWT is intentionally not used to keep authentication simple and beginner-friendly.



User Features

User registration

Secure login

BMI calculation

Waist size risk calculation

Automatic diet plan generation based on BMI & waist risk

View personal diet plans

View BMI progress history (used for charts in frontend)



Admin Features

Admin-only access using role-based security

View all users’ diet plans

Monitor overall health data

Admin endpoints protected from normal users




Business Logic

BMI Calculation

Uses height and weight

Classifies as UNDERWEIGHT, NORMAL, or OVERWEIGHT

Waist Risk Analysis

LOW, MEDIUM, HIGH risk levels

Diet Plan Generation

Diet plans are generated dynamically based on BMI status and waist risk

Includes breakfast, lunch, and dinner suggestions

BMI History

Each BMI entry is stored and retrievable for progress visualization
