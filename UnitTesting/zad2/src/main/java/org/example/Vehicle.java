package org.example;

abstract class Vehicle {
    private String registration;

    public Vehicle(String registration) {
        this.registration=registration;
    }
    public String getRegistration() {
        return registration;
    }

    abstract public double getConsumption();
}
