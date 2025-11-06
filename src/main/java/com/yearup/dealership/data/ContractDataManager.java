package com.yearup.dealership.data;

import com.yearup.dealership.model.Contract;
import com.yearup.dealership.model.LeaseContract;
import com.yearup.dealership.model.SalesContract;
import com.yearup.dealership.model.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    public void saveContract(Contract contract) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            Vehicle vehicle = contract.getVehicle();

            String contractType;
            if (contract instanceof SalesContract) {
                contractType = "SALE";
            } else {
                contractType = "LEASE";
            }

            String baseInfo = String.format("%s|%s|%s|%s|%d|%s|%s|%s|%s|%s|%d|%.2f",
                    contractType,
                    contract.getContractDate(),  // no DateTimeFormatter
                    contract.getCustomerName(),
                    contract.getCustomerEmail(),
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()

            );
            if (contract instanceof SalesContract) {
                SalesContract sale = (SalesContract) contract;

                String financedText;
                if (sale.getMonthlyPayment() > 0) {
                    financedText = "YES";
                } else {
                    financedText = "NO";
                }

                String line = String.format(
                        "%s|%.2f|100.00|%.2f|%.2f|%s|%.2f",
                        baseInfo,
                        vehicle.getPrice() * 0.05, // sales tax
                        sale.getProcessingFee(),
                        sale.getTotalPrice(),
                        financedText,
                        sale.getMonthlyPayment()
                );

                writer.write(line + "\n");

            } else if (contract instanceof LeaseContract) {
                LeaseContract lease = (LeaseContract) contract;

                String line = String.format(
                        "%s|%.2f|%.2f|%.2f|%.2f",
                        baseInfo,
                        lease.getVehicle().getPrice() * 0.5,  // expected ending value
                        lease.getVehicle().getPrice() * 0.07, // lease fee
                        lease.getTotalPrice(),
                        lease.getMonthlyPayment()
                );

                writer.write(line + "\n");
            }
            writer.flush();
            System.out.println("Contract saved successfully");
        }
    }
}
