package com.yearup.dealership;

import java.time.LocalDate;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leasingFee = 0.07;

    public LeaseContract(LocalDate contractDate, String customerName, String customerEmail, Vehicle vehicles) {
        super(contractDate, customerName, customerEmail, vehicles);
    }

    public LeaseContract(LocalDate contractDate, String customerName, String customerEmail, Vehicle vehicles, double expectedEndingVaule, double leasingFee) {
        super(contractDate, customerName, customerEmail, vehicles);
        this.expectedEndingValue = expectedEndingVaule;
        this.leasingFee = leasingFee;
    }

    @Override
    public double getTotalPrice() {

        double leasingFee = getVehicle().getPrice() * leasingFee;
        return expectedEndingValue + leasingFee;
    }

    @Override
    public double getMonthlyPayment() {
        double total = getTotalPrice();
        double rate = 0.04 / 12;
        int months = 36;
        return (total * rate) / (1 - Math.pow(1 + rate, -months));
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeasingFee() {
        return leasingFee;
    }

    public void setLeasingFee(double leasingFee) {
        this.leasingFee = leasingFee;
    }


}
