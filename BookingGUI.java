/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.taxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingGUI extends JFrame {

    private Booking booking;
    private DatabaseConnection dbConnection;
    private JTextField nameField, luggageField;
    private JComboBox<Location> startPointComboBox, endPointComboBox;
    private JComboBox<Driver> driverComboBox;
    private JComboBox<Taxi> taxiComboBox;
    private JSpinner dateSpinner, timeSpinner;

    public BookingGUI() {
        setTitle("Taxi Booking System");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        // Initialize components
        nameField = new JTextField();
        luggageField = new JTextField();
        
        startPointComboBox = new JComboBox<>(Location.values());
        endPointComboBox = new JComboBox<>(Location.values());
        driverComboBox = new JComboBox<>(Driver.values());
        taxiComboBox = new JComboBox<>(Taxi.values());
        
        dateSpinner = new JSpinner(new SpinnerDateModel());
        timeSpinner = new JSpinner(new SpinnerDateModel());

        // Add components to the frame
        add(new JLabel("Customer Name:"));
        add(nameField);
        add(new JLabel("Start Point:"));
        add(startPointComboBox);
        add(new JLabel("End Point:"));
        add(endPointComboBox);
        add(new JLabel("Driver:"));
        add(driverComboBox);
        add(new JLabel("Taxi:"));
        add(taxiComboBox);
        add(new JLabel("Pickup Date:"));
        add(dateSpinner);
        add(new JLabel("Pickup Time:"));
        add(timeSpinner);
        add(new JLabel("Luggage Pieces:"));
        add(luggageField);

        JButton confirmButton = new JButton("Confirm Booking");
        JButton cancelButton = new JButton("Cancel Booking");

        add(confirmButton);
        add(cancelButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmBooking();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelBooking();
            }
        });

        // Database connection
        dbConnection = new DatabaseConnection();
        setVisible(true);
    }

    private void confirmBooking() {
        String name = nameField.getText();
        Location startPoint = (Location) startPointComboBox.getSelectedItem();
        Location endPoint = (Location) endPointComboBox.getSelectedItem();
        Driver selectedDriver = (Driver) driverComboBox.getSelectedItem();
        Taxi selectedTaxi = (Taxi) taxiComboBox.getSelectedItem();
        LocalDate dateOfPickup = ((SpinnerDateModel) dateSpinner.getModel()).getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalTime timeOfPickup = ((SpinnerDateModel) timeSpinner.getModel()).getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalTime();
        int piecesOfLuggage = Integer.parseInt(luggageField.getText());

        // Create booking object and confirm
        booking = new Booking(name, selectedTaxi, selectedDriver, startPoint, endPoint, dateOfPickup, timeOfPickup, piecesOfLuggage);
        booking.confirmBooking(dbConnection.getConnection());
    }

    private void cancelBooking() {
        if (booking != null) {
            booking.cancelBooking(dbConnection.getConnection());
        } else {
            System.out.println("No booking to cancel.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookingGUI());
    }
}
