/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taxi;

public enum Taxi {

    TAXI1("ABC123", TaxiType.SEDAN),
    TAXI2("XYZ789", TaxiType.MINIVAN),
    TAXI3("DEF456", TaxiType.SUV),
    TAXI4("GHI789", TaxiType.MINIVAN),
    TAXI5("JKL012", TaxiType.SEDAN);

    private final String licensePlate;
    private final TaxiType model;

    enum TaxiType {
        SEDAN,
        SUV,
        MINIVAN
    }

    private Taxi(String licensePlate, TaxiType model) {
        this.licensePlate = licensePlate;
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public TaxiType getModel() {
        return model;
    }
}
