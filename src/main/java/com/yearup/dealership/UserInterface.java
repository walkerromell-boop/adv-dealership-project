package com.yearup.dealership;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //Display Method controls the user interface
    private Dealership dealership;
    Scanner scanner = new Scanner(System.in);


    public void displayMainMenu() {
        try {
            init(); // load dealership before menu
        } catch (FileNotFoundException e) {
            System.out.println("Error loading dealership data: " + e.getMessage());
            return;
        }
//        Call the private init

        boolean running = true;

        while (running) {
//add display menu here
            displayMenu();
            System.out.println("Enter your command: ");
            String choice = scanner.nextLine().trim().toLowerCase();
            try {
                switch (choice) {
                    case "1":
                        processGetByPrice();
//                        display search by price menu
                        break;
                    case "2":
                        processGetByMakeModel();
//                        display search by model menu
                        break;
                    case "3":
                        processAllVehiclesRequest();
                        break;
//                        display search by year menu
                    case "4":
//                        display search by color menu
                        break;
                    case "5":
//                  display search by mileage menu
                        break;
                    case "6":
//                        display search by vehicle type
                        break;
                    case "7":


                        //show all vehicles display
                        break;
                    case "8":
                        processAllVehiclesRequest();
                        //show add vehicle method
                        break;
                    case "9":
                        //add remove car method
                        break;
                    case "10":
                        running = false;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

    private void init() throws FileNotFoundException {
        DealershipFileManger fileManger = new DealershipFileManger();
        dealership = fileManger.getDealership();
    }

    private void displayMenu() {
        System.out.println("\n=== Dealership Menu ===");
        System.out.println("1. Find vehicles by price range");
        System.out.println("2. Find vehicles by make/model");
        System.out.println("3. Show all vehicles");
        System.out.println("4. search by year");
        System.out.println("5. search by color");
        System.out.println("6. search by mileage");
        System.out.println("7. search by vehicle type");
        System.out.println("8. search all vehicles");
        System.out.println("9. add vehicle to list");
        System.out.println("10. remove vehicle from list");
        System.out.println("11. Exit");
        System.out.println("========================");
    }

    private void processGetByPrice() {
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());


        List<Vehicle> results = dealership.getVehicleByPrice(min, max);
        displayVehicles(results);
    }

    private void processGetByMakeModel() {
        System.out.print("Enter make or model: ");
        String search = scanner.nextLine().toLowerCase();


        List<Vehicle> results = dealership.getVehicleByMakeModel(search);

        //  Display results
        if (results.isEmpty()) {
            System.out.println("No vehicles found matching: " + search);
        } else {
            System.out.println("\n=== Vehicles matching '" + search + "' ===");
            for (Vehicle v : results) {
                System.out.println(v);
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles to display.");
            return;
        }

        System.out.println("\n=== Vehicle List ===");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void processAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

}
