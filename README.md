# 💰 Expense Tracker

A simple yet powerful **Expense Tracker** application built using **Spring Boot** for the backend and **HTML/CSS/JavaScript** for the frontend. This tool helps users efficiently track, categorize, and manage their daily personal expenses.

---

## 🚀 Features

✅ Add new expenses with category, description, date, and amount  
✅ List all expenses in a tabular format  
✅ Filter expenses by category  
✅ View total expense across all categories  
✅ View total expense for a specific category  
✅ Delete an expense by its ID  
✅ Responsive and user-friendly UI  
✅ API documentation with Swagger

---

## 🔁 API Endpoints

| Method | Endpoint                                      | Description                          |
|--------|-----------------------------------------------|--------------------------------------|
| `POST` | `/api/expenses`                               | Create a new expense                 |
| `PUT`  | `/api/expenses/{id}`                          | Update an existing expense by ID     |
| `GET`  | `/api/expenses/{id}`                          | Retrieve a single expense by ID      |
| `GET`  | `/api/expenses/list`                          | Retrieve all expenses                |
| `GET`  | `/api/expenses/category/{category}`           | Retrieve expenses by category        |
| `GET`  | `/api/expenses/total/all`                     | Get total of all expenses            |
| `GET`  | `/api/expenses/total/category/{category}`     | Get total expenses by category       |
| `DELETE` | `/api/expenses/{id}`                        | Delete an expense by ID              |

---

## 📦 Technologies Used

### 🖥️ Backend:
- Java 17
- Spring Boot (REST APIs)
- Spring Data JPA
- Hibernate
- PostgreSQL (DB for development/testing)
- Maven
- Swagger/OpenAPI (for API documentation)

### 🌐 Frontend:
- HTML5
- CSS3 (with external styles in `css/styles.css`)
- Vanilla JavaScript (in `js/app.js`)

---

## 🧪 Getting Started

### ✅ Prerequisites
- Java 17 or higher
- Maven 3.6+

---

### 🔧 Installation & Running

```bash
# Clone the repository
git clone https://github.com/your-username/expense-tracker.git

# Navigate to the project directory
cd expense-tracker

# Run the Spring Boot app
mvn spring-boot:run
```

---

## 🌍 Accessing the Application

- **Swagger UI (API Docs):**  
  📎 [http://localhost:8081/swagger-ui/index.html#/](http://localhost:8081/swagger-ui/index.html#/)

- **Expense Tracker UI:**  
  📎 [http://localhost:8081/expense-tracker/index.html](http://localhost:8081/expense-tracker/index.html)

---

## 🧾 Example Expense JSON (POST)

```json
{
  "description": "Lunch with friends",
  "category": "Food",
  "amount": 450.00,
  "date": "2025-05-09"
}
```

---

---

## 🧰 Future Improvements

- User login & registration
- Export expenses to CSV or PDF
- Chart/graph visualizations (e.g., PieChart, BarGraph)
- Monthly or custom date range filters
- Mobile responsiveness
