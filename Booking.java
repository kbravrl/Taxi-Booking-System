package com.example.taxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private String customer;
    private Taxi selectedTaxi;
    private Driver selectedDriver;
    private Location startPoint;
    private Location endPoint;
    private LocalDate dateOfPickup;
    private LocalTime timeOfPickup;
    private int piecesOfLuggage;

    public Booking() {
    }

    
    public Booking(String customer, Taxi selectedTaxi, Driver selectedDriver, Location startPoint, Location endPoint, LocalDate dateOfPickup, LocalTime timeOfPickup, int piecesOfLuggage) {
        this.customer = customer;
        this.selectedTaxi = selectedTaxi;
        this.selectedDriver = selectedDriver;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.dateOfPickup = dateOfPickup;
        this.timeOfPickup = timeOfPickup;
        this.piecesOfLuggage = piecesOfLuggage;
    }

    public void confirmBooking(Connection connection) {
        if (selectedTaxi == null || selectedDriver == null) {
            System.out.println("Error confirming reservation: Selected taxi or driver is null.");
            return;
        }
        try {
            String query = "INSERT INTO Booking (customer_name, selected_taxi_license_plate, selected_driver_name, start_point, end_point, date_of_pickup, time_of_pickup, pieces_of_luggage) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customer);
            statement.setString(2, selectedTaxi.getLicensePlate());
            statement.setString(3, selectedDriver.getName());
            statement.setString(4, startPoint.getLocationName());
            statement.setString(5, endPoint.getLocationName());
            statement.setDate(6, java.sql.Date.valueOf(dateOfPickup));
            statement.setTime(7, java.sql.Time.valueOf(timeOfPickup));
            statement.setInt(8, piecesOfLuggage);
            statement.executeUpdate();
            System.out.println("Your reservation is confirmed.");
        } catch (SQLException e) {
            System.out.println("Error confirming reservation: " + e.getMessage());
        }
    }

    public void cancelBooking(Connection connection) {
        try {
            String query = "DELETE FROM Booking WHERE customer_name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customer);
            statement.executeUpdate();
            System.out.println( customer + " reservation is canceled.");
        } catch (SQLException e) {
            System.out.println("Error canceling reservation: " + e.getMessage());
        }
    }
    
    public void listAllBookings(Connection connection) {
        try {
            String query = "SELECT * FROM Booking";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String customerName = resultSet.getString("customer_name");
                String taxiLicensePlate = resultSet.getString("selected_taxi_license_plate");
                String driverName = resultSet.getString("selected_driver_name");
                String startPoint = resultSet.getString("start_point");
                String endPoint = resultSet.getString("end_point");
                LocalDate dateOfPickup = resultSet.getDate("date_of_pickup").toLocalDate();
                LocalTime timeOfPickup = resultSet.getTime("time_of_pickup").toLocalTime();
                int piecesOfLuggage = resultSet.getInt("pieces_of_luggage");

                System.out.println("Customer: " + customerName + ", Taxi: " + taxiLicensePlate + ", Driver: " + driverName +
                        ", Start Point: " + startPoint + ", End Point: " + endPoint +
                        ", Date of Pickup: " + dateOfPickup + ", Time of Pickup: " + timeOfPickup +
                        ", Pieces of Luggage: " + piecesOfLuggage);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error listing bookings: " + e.getMessage());
        }
    }

    public static void deleteAllBookings(Connection connection) {
        try {
            String query = "DELETE FROM Booking";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("All bookings have been deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting bookings: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "customer=" + customer + ", selectedTaxi=" + selectedTaxi
                + ", selectedDriver=" + selectedDriver + ", startPoint=" + startPoint
                + ", endPoint=" + endPoint + ", dateOfPickup=" + dateOfPickup + ", timeOfPickup="
                + timeOfPickup + ", piecesOfLuggage=" + piecesOfLuggage;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Taxi getSelectedTaxi() {
        return selectedTaxi;
    }

    public void setSelectedTaxi(Taxi selectedTaxi) {
        this.selectedTaxi = selectedTaxi;
    }

    public Driver getSelectedDriver() {
        return selectedDriver;
    }

    public void setSelectedDriver(Driver selectedDriver) {
        this.selectedDriver = selectedDriver;
    }

    public Location getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Location startPoint) {
        this.startPoint = startPoint;
    }

    public Location getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Location endPoint) {
        this.endPoint = endPoint;
    }

    public LocalDate getDateOfPickup() {
        return dateOfPickup;
    }

    public void setDateOfPickup(LocalDate dateOfPickup) {
        this.dateOfPickup = dateOfPickup;
    }

    public LocalTime getTimeOfPickup() {
        return timeOfPickup;
    }

    public void setTimeOfPickup(LocalTime timeOfPickup) {
        this.timeOfPickup = timeOfPickup;
    }

    public int getPiecesOfLuggage() {
        return piecesOfLuggage;
    }

    public void setPiecesOfLuggage(int piecesOfLuggage) {
        this.piecesOfLuggage = piecesOfLuggage;
    }
}
