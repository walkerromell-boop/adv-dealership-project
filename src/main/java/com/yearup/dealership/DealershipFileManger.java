package com.yearup.dealership;

import java.io.*;

public class DealershipFileManger {

    public Dealership getDealership() throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //read the first line of dealership info
            String dealershipLine = bufferedReader.readLine();
            String[] parts = dealershipLine.split("\\|");
            Dealership dealership = new Dealership(parts[0], parts[1], parts[2]);

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
            }
            bufferedReader.close();
            return dealership;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

    }

    public Dealership saveDealership() {
        return null;
    }




}
