# 💰 Expense Tracker API

A simple RESTful API built with Spring Boot for tracking and managing personal expenses.

---

## 🚀 Features

- Add new expenses
- Retrieve all expenses
- Filter expenses by category
- View total expenses across all categories
- View total expenses for a specific category
- Delete an expense by ID

---

## 📘 API Endpoints

| Method | Endpoint                              | Description                                  |
|--------|----------------------------------------|----------------------------------------------|
| POST   | `/api/expenses`                        | Save a new expense                           |
| GET    | `/api/expenses`                        | Get all expenses                             |
| GET    | `/api/expenses/category/{category}`    | Get all expenses by category                 |
| GET    | `/api/expenses/total`                  | Get total expense (all categories)           |
| GET    | `/api/expenses/total/{category}`       | Get total expense for a specific category    |
| DELETE | `/api/expenses/{id}`                   | Delete an expense by ID                      |

---

## 🛠 Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL Database
- Maven

---

## 🧪 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+

### Run Locally

```bash
git clone https://github.com/your-username/expense-tracker.git
cd expense-tracker
mvn spring-boot:run
