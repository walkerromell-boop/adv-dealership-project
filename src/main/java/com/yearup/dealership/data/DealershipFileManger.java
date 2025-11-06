package com.yearup.dealership.data;

import com.yearup.dealership.model.Dealership;
import com.yearup.dealership.model.Vehicle;

import java.io.*;

public class DealershipFileManger {

    public Dealership getDealership()  {
        Dealership dealership=null;
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //read the first line of dealership info
            String dealershipLine = bufferedReader.readLine();
            String[] parts = dealershipLine.split("\\|");
             dealership = new Dealership(parts[0], parts[1], parts[2]);

            //this part reads each vehicle line
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\\|");

                Vehicle vehicle = new Vehicle(
                        Integer.parseInt(data[0]), //Vin
                        Integer.parseInt(data[1]), //year
                        data[2], //Make
                        data[3], //MOdel
                        data[4], //type
                        data[5], //color
                        Integer.parseInt(data[6]), //odometer
                        Double.parseDouble(data[7])
                );
                dealership.addVehicle(vehicle);
                System.out.println("Loaded vehicle: " + vehicle.getMake() + " " + vehicle.getModel());
            }
            bufferedReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        return dealership;
    }

    public Dealership saveDealership() {
        return null;
    }




}
