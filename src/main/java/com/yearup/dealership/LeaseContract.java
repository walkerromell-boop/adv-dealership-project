package com.yearup.dealership;

import java.time.LocalDate;

public class LeaseContract extends Contract {
    private double expectedEndingVaule;
    private double leasingFee;

    public LeaseContract(LocalDate contractDate, String customerName, String customerEmail, Vehicle vehicles) {
        super(contractDate, customerName, customerEmail, vehicles);
    }

    public LeaseContract(LocalDate contractDate, String customerName, String customerEmail, Vehicle vehicles, double expectedEndingVaule, double leasingFee) {
        super(contractDate, customerName, customerEmail, vehicles);
        this.expectedEndingVaule = expectedEndingVaule;
        this.leasingFee = leasingFee;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }

    public double getExpectedEndingVaule() {
        return expectedEndingVaule;
    }

    public void setExpectedEndingVaule(double expectedEndingVaule) {
        this.expectedEndingVaule = expectedEndingVaule;
    }

    public double getLeasingFee() {
        return leasingFee;
    }

    public void setLeasingFee(double leasingFee) {
        this.leasingFee = leasingFee;
    }

    public double getTotalPrice() {
        return getTotalPrice();
    }


}
