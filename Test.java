package com.example.taxi;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;

public class Test {

    public static void main(String[] args) {
        // Establish database connection
        Connection connection = new DatabaseConnection().getConnection();

        // Create taxis and drivers
        Taxi taxi1 = Taxi.TAXI1;
        Taxi taxi2 = Taxi.TAXI2;
        Taxi taxi3 = Taxi.TAXI3;
        Taxi taxi4 = Taxi.TAXI4;
        Taxi taxi5 = Taxi.TAXI5;

        Driver driver1 = Driver.JOHN_DOE;
        Driver driver2 = Driver.JANE_SMITH;
        Driver driver3 = Driver.ROBERT_JOHNSON;
        Driver driver4 = Driver.EMMA_WILLIAMS;
        Driver driver5 = Driver.MICHAEL_BROWN;

        // Create bookings
        Booking booking1 = new Booking("John Smith", taxi1, driver1, Location.CITYCENTER, Location.SUBURB,
                LocalDate.of(2023, 9, 15), LocalTime.of(10, 30), 2);

        Booking booking2 = new Booking("Alice Johnson", taxi2, driver2, Location.AIRPORT, Location.CITYCENTER,
                LocalDate.of(2023, 9, 20), LocalTime.of(15, 45), 3);

        Booking booking3 = new Booking("Bob Brown", taxi3, driver3, Location.HIGHWAY, Location.MOUNTAIN,
                LocalDate.of(2023, 9, 18), LocalTime.of(14, 0), 1);

        // Confirm bookings
        booking1.confirmBooking(connection);
        booking2.confirmBooking(connection);
        booking3.confirmBooking(connection);

        // Cancel a booking
        System.out.println("\nBooking Cancellation:");
        booking1.cancelBooking(connection);

        // List all bookings
        System.out.println("\nAll Bookings:");
        Booking listBooking = new Booking();
        listBooking.listAllBookings(connection);
        
        // Close connection
        new DatabaseConnection().closeConnection();
    }
}
