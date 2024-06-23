/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taxi;

enum Driver {
    JOHN_DOE("John Doe", Gender.MALE, "555-1234"),
    JANE_SMITH("Jane Smith", Gender.FEMALE, "555-5678"),
    ROBERT_JOHNSON("Robert Johnson", Gender.MALE, "555-8765"),
    EMMA_WILLIAMS("Emma Williams", Gender.FEMALE, "555-4321"),
    MICHAEL_BROWN("Michael Brown", Gender.MALE, "555-7890");

    private final String name;
    private final Gender gender;
    private final String phoneNumber;

    Driver(String name, Gender gender, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }
}
