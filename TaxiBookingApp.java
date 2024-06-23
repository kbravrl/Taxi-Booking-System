package com.example.taxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class TaxiBookingApp extends JFrame implements ActionListener {
    private JLabel nameLabel, taxiLabel, driverLabel, startPointLabel, endPointLabel, dateLabel, timeLabel, luggageLabel;
    private JTextField nameField, dateField, timeField, luggageField;
    private JComboBox<Taxi> taxiCombo;
    private JComboBox<Driver> driverCombo;
    private JComboBox<Location> startPointCombo, endPointCombo;
    private JButton bookButton;

    public TaxiBookingApp() {
        setTitle("Taxi Booking App");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

        nameLabel = new JLabel(" Name :");
        add(nameLabel);

        nameField = new JTextField();
        add(nameField);

        taxiLabel = new JLabel(" Select Taxi :");
        add(taxiLabel);

        taxiCombo = new JComboBox<>(Taxi.values());
        add(taxiCombo);

        driverLabel = new JLabel(" Select Driver :");
        add(driverLabel);

        driverCombo = new JComboBox<>(Driver.values());
        add(driverCombo);

        startPointLabel = new JLabel(" Start Point :");
        add(startPointLabel);

        startPointCombo = new JComboBox<>(Location.values());
        add(startPointCombo);

        endPointLabel = new JLabel(" End Point :");
        add(endPointLabel);

        endPointCombo = new JComboBox<>(Location.values());
        add(endPointCombo);

        dateLabel = new JLabel(" Date (YYYY-MM-DD):");
        add(dateLabel);

        dateField = new JTextField();
        add(dateField);

        timeLabel = new JLabel(" Time (HH:MM):");
        add(timeLabel);

        timeField = new JTextField();
        add(timeField);

        luggageLabel = new JLabel(" Number of Luggage :");
        add(luggageLabel);

        luggageField = new JTextField();
        add(luggageField);

        bookButton = new JButton(" Book");
        bookButton.addActionListener(this);
        add(bookButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            String name = nameField.getText();
            Taxi selectedTaxi = (Taxi) taxiCombo.getSelectedItem();
            Driver selectedDriver = (Driver) driverCombo.getSelectedItem();
            Location startPoint = (Location) startPointCombo.getSelectedItem();
            Location endPoint = (Location) endPointCombo.getSelectedItem();
            LocalDate date = LocalDate.parse(dateField.getText());
            LocalTime time = LocalTime.parse(timeField.getText());
            int luggage = Integer.parseInt(luggageField.getText());

            // Burada rezervasyonu işle ve diğer işlemleri yap
            System.out.println("Booking confirmed for " + name + " from " + startPoint.getLocationName() + " to " + endPoint.getLocationName() + " on " + date + " at " + time + " with " + luggage + " pieces of luggage.");
        }
    }

    public static void main(String[] args) {
        new TaxiBookingApp();
    }
}
