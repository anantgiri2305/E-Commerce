# E-Commerce

This is a simple E-commerce web application built with Spring Boot, Thymeleaf, and MySQL. It supports user registration, login, product listing, add-to-cart functionality, and admin product management.

🚀 Features
    ** User registration and login
    ** Product listing page
    ** Admin can add/delete products
    ** Add to cart functionality
    ** View cart page
    ** Simple Thymeleaf templates for frontend
    
🛠️ Tech Stack
Backend: Spring Boot, Spring MVC, Spring Data JPA

** Frontend: Thymeleaf

** Database: MySQL

** Build Tool: Maven

📁 Project Structure

src/
├── main/
│   ├── java/
│   │   └── com.ecommerce/
│   │       ├── controller/          # Controllers
│   │       ├── model/               # Entity classes
│   │       ├── repository/          # Spring Data JPA Repos
│   │       ├── services/            # Service layer
│   │       └── ECommerceApplication.java
│   └── resources/
│       ├── templates/               # Thymeleaf HTML files
│       ├── application.properties   # DB config and settings
│       └── static/                  # Static assets (CSS, JS)


🔧 Configuration

MySQL Database Setup
Create a database named ecommerce_db in MySQL:
CREATE DATABASE ecommerce_db;

** application.properties --

        spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
        spring.datasource.username=root
        spring.datasource.password=your_password
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.thymeleaf.cache=false

        
🧪 Run the App
Clone the project

git clone https://github.com/your-username/ecommerce-app.git
cd ecommerce-app
Run the app

In your IDE, run the ECommerceApplication class as a Java application, or use:

bash
Copy code
mvn spring-boot:run
Access the app

Visit: http://localhost:8080

Register as a user at /register

Admin can access /admin/add-product to add new products

Visit /products to view and add products to the cart

📝 Sample Credentials
Role	    Email	        Password
User	user@example.com	user123
Admin	admin@example.com	admin123

📦 Sample Data Initialization
The ProductController includes a @PostConstruct method that auto-inserts a sample product on first run.

