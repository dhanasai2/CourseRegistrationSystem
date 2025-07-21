# Course Registration System

A comprehensive web-based course registration system built with Java servlets, MySQL database, and modern responsive CSS. This application allows students to register for courses, login to view their profiles, and administrators to view all registered students.

## 🚀 Features

### Student Features
- **User Registration** with comprehensive form validation
- **Course Selection** with multiple checkbox options
- **Learning Mode Selection** (Online, Offline, Hybrid)
- **User Authentication** with secure login system
- **Profile Dashboard** displaying all registered information
- **Responsive Design** that works on desktop and mobile devices

### Administrative Features
- **View All Students** in a comprehensive table format
- **Database Integration** with MySQL for persistent storage
- **Real-time Data** with immediate updates

### Technical Features
- **Professional UI/UX** with gradient backgrounds and animations
- **Interactive Elements** with hover effects and loading animations
- **Form Validation** both client-side and server-side
- **Error Handling** with user-friendly error messages
- **Session Management** for secure user sessions

## 🛠️ Technology Stack

- **Backend**: Java Servlets, JDBC
- **Frontend**: HTML5, CSS3, JavaScript
- **Database**: MySQL
- **Server**: Apache Tomcat 9
- **IDE**: Eclipse IDE
- **Build Tool**: Maven (optional)

## 📋 Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK) 8 or higher**
- **Apache Tomcat 9.0 or higher**
- **MySQL Server 8.0 or higher**
- **Eclipse IDE** with Java EE support
- **MySQL Workbench** or MySQL Command Line Client

## 🔧 Installation & Setup

### 1. Clone/Download the Project
If using Git
git clone <your-repository-url>

Or download and extract the ZIP file
text

### 2. Database Setup

#### Using MySQL Command Line:
-- Connect to MySQL
mysql -u root -p

-- Create database
CREATE DATABASE course_registration_db;

-- Use the database
USE course_registration_db;

-- Create students table
CREATE TABLE students (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
password VARCHAR(100) NOT NULL,
phone VARCHAR(15),
gender VARCHAR(10),
education VARCHAR(50),
courses TEXT,
learning_mode VARCHAR(20),
comments TEXT,
registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

text

### 3. Configure Database Connection

Edit `DatabaseConnection.java` in `src/main/java/com/course/servlet/`:

private static final String PASSWORD = "your_mysql_password"; // Update this!

text

Replace `"your_mysql_password"` with your actual MySQL root password.

### 4. Import Project into Eclipse

1. Open Eclipse IDE
2. Go to **File → Import → Existing Projects into Workspace**
3. Select the project directory
4. Click **Finish**

### 5. Add MySQL JDBC Driver

#### For Maven Projects:
Add to `pom.xml`:
<dependency> <groupId>com.mysql</groupId> <artifactId>mysql-connector-j</artifactId> <version>8.0.33</version> </dependency> ```
For Regular Projects:
Download MySQL Connector/J from MySQL website

Right-click project → Build Path → Configure Build Path

Libraries → Add External JARs

Select the downloaded JAR file

6. Configure Tomcat Server
In Eclipse, go to Servers tab

Right-click → New → Server

Select Apache Tomcat v9.0

Browse to your Tomcat installation directory

Click Finish

🚀 Running the Application
Clean the project: Project → Clean

Right-click on project → Run As → Run on Server

Select Tomcat 9 → Finish

Access the application in your browser

🌐 Application URLs
After starting the server, access these URLs:

Page	URL	Description
Registration	http://localhost:8080/CourseRegistrationSystem/registration.html	Student registration form
Login	http://localhost:8080/CourseRegistrationSystem/login.html	Student login page
Database Test	http://localhost:8080/CourseRegistrationSystem/TestDatabaseServlet	Test database connectivity
All Students	http://localhost:8080/CourseRegistrationSystem/AllStudentsServlet	View all registered students
📁 Project Structure
text
CourseRegistrationSystem/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── course/
│       │           └── servlet/
│       │               ├── Student.java                 # Data model
│       │               ├── StudentDatabase.java         # Database operations
│       │               ├── DatabaseConnection.java      # DB connection utility
│       │               ├── RegisterServlet.java         # Registration handler
│       │               ├── LoginServlet.java           # Login handler
│       │               ├── AllStudentsServlet.java     # View all students
│       │               └── TestDatabaseServlet.java    # DB connection test
│       └── webapp/
│           ├── styles.css           # Professional CSS styling
│           ├── registration.html    # Registration form
│           └── login.html          # Login form
└── pom.xml (if using Maven)
💾 Database Schema
Students Table
Column	Type	Constraints	Description
id	INT	PRIMARY KEY, AUTO_INCREMENT	Unique identifier
first_name	VARCHAR(50)	NOT NULL	Student's first name
last_name	VARCHAR(50)	NOT NULL	Student's last name
email	VARCHAR(100)	UNIQUE, NOT NULL	Email address (login ID)
password	VARCHAR(100)	NOT NULL	User password
phone	VARCHAR(15)		Phone number
gender	VARCHAR(10)		Gender selection
education	VARCHAR(50)		Education level
courses	TEXT		Comma-separated course list
learning_mode	VARCHAR(20)		Online/Offline/Hybrid
comments	TEXT		Additional comments
registration_date	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP	Registration timestamp
🎨 Features Showcase
Registration Form
Interactive course cards with gradient backgrounds

Radio button selections for gender and learning mode

Checkbox selections for multiple courses

Form validation with error messages

Loading animations on form submission

Login System
Secure authentication against database

Session management for user sessions

Error handling for invalid credentials

Responsive design for all devices

Dashboard
Professional table display of user information

Course enrollment display with formatted lists

Navigation buttons with hover effects

Consistent styling across all pages

🔒 Security Features
SQL Injection Protection using PreparedStatements

Input Validation on both client and server side

Session Management for secure user sessions

Password Storage (Note: Consider implementing password hashing for production)

🧪 Testing
Test Database Connection
Navigate to /TestDatabaseServlet

Verify "Database Connection Successful!" message

Test Registration
Fill out registration form with test data

Verify success message and data display

Check MySQL database for stored record

Test Login
Use registered credentials to login

Verify profile dashboard displays correctly

Test "View All Students" functionality

Test Error Scenarios
Try registering with duplicate email

Try logging in with wrong credentials

Verify appropriate error messages display

🐛 Troubleshooting
Common Issues
Database Connection Failed
Check MySQL server is running

Verify password in DatabaseConnection.java

Confirm database and table exist

Check MySQL JDBC driver is added

CSS Not Loading
Verify styles.css is in src/main/webapp/

Clear browser cache (Ctrl+F5)

Check browser developer tools for 404 errors

404 Servlet Not Found
Check servlet URL mappings

Verify project is deployed to Tomcat

Check project build path

Form Submission Issues
Verify form action URLs match servlet mappings

Check servlet doPost methods

Ensure all required fields are filled

Log Files
Check Tomcat console in Eclipse for error messages and stack traces.

📈 Future Enhancements
Potential Improvements
Password Encryption (BCrypt hashing)

Email Verification for registration

Course Management (Add/Edit/Delete courses)

User Roles (Student/Admin/Instructor)

Advanced Search and filtering

File Upload for profile pictures

Export Data to PDF/Excel

REST API development

Spring Boot migration

Performance Optimizations
Connection Pooling for database connections

Caching for frequently accessed data

Pagination for large student lists

AJAX for dynamic content loading

🤝 Contributing
Fork the repository

Create a feature branch (git checkout -b feature/AmazingFeature)

Commit your changes (git commit -m 'Add some AmazingFeature')

Push to the branch (git push origin feature/AmazingFeature)

Open a Pull Request

📄 License
This project is licensed under the MIT License - see the LICENSE.md file for details.

👥 Authors
Your Name - Initial work - YourGitHub

🙏 Acknowledgments
Oracle for Java Servlet technology

MySQL for database management

Apache Tomcat for servlet container

Eclipse Foundation for the IDE

MDN Web Docs for CSS/HTML references

📞 Support
For support and questions:

Create an issue on GitHub

Email: your-email@example.com

Documentation: Wiki

📊 Project Stats
Lines of Code: ~2000+

Languages: Java, HTML, CSS, SQL

Files: 10+ source files

Features: 15+ implemented features

Database Tables: 1 main table with 12 columns

Built with ❤️ using Java servlets and modern web technologies
