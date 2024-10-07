# Taxi Booking System

## Overview
Taxi Booking System is a Java Swing-based desktop application that allows users to book taxi rides by selecting pickup and drop-off locations, drivers, taxis, and specifying the date, time, and luggage pieces. The system provides options to confirm or cancel bookings and stores the information in a database.

## Features
- **User-friendly GUI**: Simple and intuitive interface to make bookings easily.
- **Location Selection**: Users can select starting and ending points from predefined locations.
- **Driver and Taxi Selection**: Option to choose drivers and taxis from available lists.
- **Pickup Date & Time**: Flexible options for selecting pickup date and time.
- **Luggage Details**: Enter the number of luggage pieces for better service planning.
- **Booking Management**: Users can confirm or cancel bookings as needed.
- **Database Integration**: Bookings are stored and managed in a connected database.

## System Components
- **GUI**: Built using Java Swing for a desktop-based user interface.
- **Database**: A SQL database for storing booking details such as customer name, taxi, driver, and trip information.
- **Backend**: Java classes managing the interaction between the GUI and the database.

## GUI Functionality

- **Add Booking**: Users can input their details to create a new taxi booking.
- **Cancel Booking**: Users can cancel their bookings using their name and the selected taxi and driver information.
- **List Bookings**: Users can view all existing bookings stored in the database.

## Prerequisites

- Java Development Kit (JDK) 11 or later
- MySQL Server
- JDBC Driver for MySQL
