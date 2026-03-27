# AF0519704--GymMembership
This project demonstrates a complete CRUD (Create, Read, Update, Delete) application built with core Java and JDBC — no frameworks, no ORM. It simulates a real-world gym membership system tailored for travelers who need short-term gym access (Daily / Weekly / Monthly plans) in different cities.

# 🏋️‍♂️Gym Membership Management System

> A simple console-based Java + JDBC project to manage gym memberships for travelers.

---

## 📖 Description

The **Travel Gym Membership Management System** is a beginner-friendly Java project
that connects to a MySQL database using JDBC and performs full CRUD operations
through a console menu.

It is designed for travelers who need temporary gym access — Daily, Weekly, or
Monthly — in different cities. No frameworks. No Spring. Just pure Java and SQL.

---

## 🎯 Purpose

- Practice Java JDBC with a real-world use case
- Understand database connection, PreparedStatement, and ResultSet
- Learn how to structure a small Java project with clean separation of concerns

---

## 🛠️ Tech Used

| Technology        | Details                        |
|-------------------|--------------------------------|
| Java              | JDK 8 or above                 |
| MySQL             | Database                       |
| JDBC              | Java Database Connectivity     |
| MySQL Connector/J | JDBC Driver (.jar)             |
| Eclipse / IntelliJ| IDE                            |

---

## 📁 Files

| File                | Role                                      |
|---------------------|-------------------------------------------|
| `DBConnection.java` | Opens and returns MySQL connection        |
| `Member.java`       | Data model — stores member details        |
| `MemberDAO.java`    | Create, Read, Update, Delete operations   |
| `Main.java`         | Console menu — takes input from the user  |

---

## ✅ Features

- Add a new member with name, email, phone, city, plan, and dates
- View all members stored in the database
- Search any member by their ID
- Update member information and status
- Delete a member from the database
- Input taken directly from the console using Scanner
- PreparedStatement used for all queries — safe from SQL Injection

---

## 🗄️ Database Setup

Run the following SQL before starting the project:
```sql
