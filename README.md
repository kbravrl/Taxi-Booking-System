# TaxiBookingSystem

TaxiBookingSystem is a simple taxi booking application that allows users to make reservations with specific customers, taxis, drivers, and locations. This application is written in Java and uses a MySQL database.

## Contents

- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)

## Features

- Create reservations with customer, taxi, driver, and location details
- Confirm reservations
- Cancel reservations
- List all reservations
- Delete all reservations

## Requirements

- Java 8 or higher
- MySQL database
- mysql-connector-java-8.0.27.jar

## Installation

1. Create a database and the necessary tables in MySQL:
    ```sql
    CREATE DATABASE taxi;
    USE taxi;
    
    CREATE TABLE Booking (
        id INT AUTO_INCREMENT PRIMARY KEY,
        customer_name VARCHAR(255),
        selected_taxi_license_plate VARCHAR(255),
        selected_driver_name VARCHAR(255),
        start_point VARCHAR(255),
        end_point VARCHAR(255),
        date_of_pickup DATE,
        time_of_pickup TIME,
        pieces_of_luggage INT
    );
    ```

2. Update the database connection details in the `DatabaseConnection` class:
    ```java
    private static final String url = "jdbc:mysql://localhost:3306/taxi";
    private static final String username = "root";
    private static final String password = "password";
    ```

## Usage

### Making Reservations with GUI

1. Launch the GUI by running the `TaxiBookingApp` class:
    ```bash
    java -cp bin com.example.taxi.TaxiBookingApp
    ```

2. Enter the customer name, select a taxi, driver, start and end points, date, time, and number of luggage pieces, then click the "Book" button.

### Making Reservations via Terminal

1. Run the `Test` class to confirm, cancel, and list reservations via the terminal:
    ```bash
    java -cp bin com.example.taxi.Test
    ```
## ScreenShot
![t1](https://github.com/user-attachments/assets/1e6a940f-b758-4559-bd76-f8e0afa1301e)

