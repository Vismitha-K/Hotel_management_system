# 🏨 Hotel Management System

A Java-based desktop application designed to automate hotel operations at the reception level. The system allows staff to manage rooms, customers, employees, and drivers with ease.

---

## 📖 Description

This Hotel Management System is built using **Java Swing** for the GUI and **MySQL Workbench** as the backend database. It enables hotel reception staff to efficiently manage everyday operations like customer check-in/check-out, room availability, driver records, and more.

This project also demonstrates the integration of **JDBC (Java Database Connectivity)** with MySQL, using a custom `Conn` class for executing SQL operations.

---

## 🔧 Technologies Used

- Java (Swing for GUI)
- MySQL Workbench
- JDBC
- IntelliJ IDEA / Eclipse (Recommended IDEs)

---

## ✨ Features

- Admin login system
- Add/Search hotel rooms with filters
- Register and manage customers
- Manage employee and driver records
- View departmental budgets
- Checkout functionality with deposit tracking
- JDBC-based backend operations with custom connection class

---

## 🗃️ Database Schema

The following tables are created in the hotelmanagementsystem database:

CREATE TABLE login(username VARCHAR(50), password VARCHAR(20));
CREATE TABLE employees(name VARCHAR(25), age VARCHAR(10), gender VARCHAR(10), job VARCHAR(25), salary VARCHAR(20), phoneno VARCHAR(20), email VARCHAR(50), aadhar VARCHAR(30));
CREATE TABLE rooms(roomno VARCHAR(15), availability VARCHAR(20), cleaning_status VARCHAR(20), price VARCHAR(25), bed_type VARCHAR(20));
CREATE TABLE drivers(name VARCHAR(25), age VARCHAR(20), gender VARCHAR(20), car_company VARCHAR(25), car_model VARCHAR(20), availability VARCHAR(20), location VARCHAR(30));
CREATE TABLE customers(document VARCHAR(25), id_no VARCHAR(20), name VARCHAR(20), gender VARCHAR(25), country VARCHAR(20), room_no VARCHAR(20), checkin_time VARCHAR(50), deposit VARCHAR(20));
CREATE TABLE department(department VARCHAR(80), budget VARCHAR(10));

---

## 🚀 How to Run

1. Clone or download the project.
2. Open in your IDE (Eclipse or IntelliJ recommended).
3. Make sure MySQL Workbench is running and create the hotelmanagementsystem database.
4. Import the provided SQL schema or manually run the commands.
5. Run the HotelManagementSystem.java file to launch the app.

---

## 📈 Potential Future Enhancements

- Add role-based access control for Admin vs Receptionist
- Integrate email/SMS alerts for bookings
- Generate automated bills and invoices


