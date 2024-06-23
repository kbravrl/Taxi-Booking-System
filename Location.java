/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.example.taxi;

enum Location {
    CITYCENTER("City Center"),
    SUBURB("Suburban Area"),
    HIGHWAY("Highway"),
    AIRPORT("Airport"),
    SEASIDE("Seaside"),
    MOUNTAIN("Mountain Area"),
    INDUSTRIAL("Industrial Zone"),
    PARK("Park"),
    CINEMA("Cinema"),
    THEATRE("Theatre"),
    UNIVERSITY("University Campus"),
    SHOPPING_MALL("Shopping Mall"),
    POLICE_STATION("Police Station");

    private final String locationName;

    Location(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }
}


