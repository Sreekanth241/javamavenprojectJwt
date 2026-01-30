# Java Maven JWT Project

## 📌 Project Overview

This project is a **Spring Boot Java Backend application** built using **Maven** and secured with **JWT (JSON Web Token)** authentication. It demonstrates a standard **enterprise-style layered architecture** including Controllers, Services, Service Implementations, Entities, and Exception handling.

The application exposes REST APIs for **User management and Task management**, secured using JWT-based authentication.

---

## 🛠️ Technology Stack

* **Java**: 17+
* **Spring Boot**
* **Spring Web (REST APIs)**
* **Spring Security (JWT)**
* **Spring Data JPA**
* **Maven**
* **MySQL / H2 (configurable)**
* **JUnit (Testing)**

---

## 📂 Project Structure

```
javamavenprojectJwt
│
├── src/main/java/com/javaprojectmavenJwt/javamavenprojectJwt
│   ├── JavamavenprojectJwtApplication.java
│   │
│   ├── controller
│   │   ├── AurthController.java
│   │   └── TaskController.java
│   │
│   ├── Entity
│   │   ├── Users.java
│   │   └── Task.java
│   │
│   ├── service
│   │   ├── UserService.java
│   │   └── TaskService.java
│   │
│   ├── ServiceImpl
│   │   ├── UserServiceIml.java
│   │   └── TaskServiceIml.java
│   │
│   ├── exception
│   │   ├── APIException.java
│   │   └── TaskNotFound.java
│
├── src/main/resources
│   ├── application.properties
│   └── templates/
│
├── src/test/java
│   └── JavamavenprojectJwtApplicationTests.java
│
├── pom.xml
└── README.md

## 🔐 Authentication & Security

* Uses **JWT (JSON Web Token)** for stateless authentication
* Login API generates a JWT token
* Token must be sent in every secured API request

**Authorization Header Format:**

```
Authorization: Bearer <JWT_TOKEN>

## 🚀 API Modules

### 1️⃣ Authentication APIs (`AurthController`)

| Method | Endpoint         | Description                      |
| ------ | ---------------- | -------------------------------- |
| POST   | `/auth/register` | Register new user                |
| POST   | `/auth/login`    | Authenticate user & generate JWT |

---

### 2️⃣ Task APIs (`TaskController`)

| Method | Endpoint      | Description       |
| ------ | ------------- | ----------------- |
| POST   | `/tasks`      | Create a new task |
| GET    | `/tasks`      | Get all tasks     |
| GET    | `/tasks/{id}` | Get task by ID    |
| PUT    | `/tasks/{id}` | Update task       |
| DELETE | `/tasks/{id}` | Delete task       |

🔒 **All Task APIs are JWT protected**

---

## 🧱 Entity Details

### Users Entity

* id
* username
* password
* role

### Task Entity

* id
* title
* description
* status

---

## ⚙️ Configuration (`application.properties`)

```properties
spring.application.name=javamavenprojectJwt
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/javamavenprojectjwt
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=your_secret_key
jwt.expiration=86400000
```

---

## ▶️ How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone <your-github-repo-url>
cd javamavenprojectJwt
```

### 2️⃣ Build the Project

```bash
mvn clean install
```

### 3️⃣ Run the Application

```bash
mvn spring-boot:run
```

Application will start at:

http://localhost:8080

## 🧪 Testing with Postman

1. Call **Login API** → get JWT token
2. Copy token
3. Add Header in Postman:

   * Key: `Authorization`
   * Value: `Bearer <token>`
4. Call secured APIs

## ❗ Common Issues & Fixes

### 403 Forbidden

* JWT token missing or invalid
* Role mismatch

### 401 Unauthorized

* Token expired
* Wrong credentials

## 📌 Improvements (Future Scope)

* Role-based authorization
* Refresh Token support
* Swagger OpenAPI integration
* Global Exception Handler
* Docker support

Java Backend Developer

## ⭐ Support

If you like this project, please ⭐ the repository and share it.
