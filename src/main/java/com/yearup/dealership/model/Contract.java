package com.yearup.dealership.model;

import java.time.LocalDate;

public abstract class Contract {
    private LocalDate contractDate;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;
//    private ArrayList<Vehicle> vehicles;

    public Contract(LocalDate contractDate, String customerName, String customerEmail, Vehicle vehicles) {
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicles;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

//    public ArrayList<Vehicle> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(ArrayList<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

}
