package com.yearup.dealership;

import java.time.LocalDate;
import java.util.ArrayList;

public class SalesContract extends Contract {
    private double salesTaxAmount = 0.05;
    private double recordingFee= 100.00;
    private boolean isFinanced;



    public SalesContract(LocalDate contractDate, String customerName, String customerEmail, ArrayList<Vehicle> vehicles, double salesTaxAmount, double recordingFee, boolean isFinanced) {
        super(contractDate, customerName, customerEmail, vehicles);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.isFinanced = isFinanced;
    }

    public SalesContract(LocalDate contractDate, String customerName, String customerEmail, ArrayList<Vehicle> vehicles) {
        super(contractDate, customerName, customerEmail, vehicles);
    }


    public double getProcessingFee(){
        double proccessingFee;

        int vehiclePrice = getVehicles([7]);
        if (vehiclePrice<10000 )
        { proccessingFee = 295+ vehiclePrice;
        }else { proccessingFee= 495+vehiclePrice; }
        return proccessingFee;
    }



    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
