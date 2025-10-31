package com.yearup.dealership;

import java.time.LocalDate;
import java.util.ArrayList;

public class SalesContract extends Contract {
    private double salesTaxAmount = 0.05;
    private double recordingFee = 100.00;
    private boolean isFinanced;
    private double processingFee;


    public SalesContract(LocalDate contractDate, String customerName, String customerEmail, Vehicle vehicles, double salesTaxAmount, double recordingFee, boolean isFinanced) {
        super(contractDate, customerName, customerEmail, vehicles);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.isFinanced = isFinanced;
    }

    public double getProcessingFee() {
        if (getVehicle().getPrice() < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        return processingFee;
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicle().getPrice();
        double tax = price * salesTaxAmount;
        return price + tax + recordingFee + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0;
        }

        double total = getTotalPrice();
        double rate;
        int months;

        if (total >= 10000) {
            rate = 0.0425 / 12; // 4.25% annually
            months = 48;
        } else {
            rate = 0.0525 / 12; // 5.25% annually
            months = 24;
        }

        return (total * rate) / (1 - Math.pow(1 + rate, -months));
    }
}

