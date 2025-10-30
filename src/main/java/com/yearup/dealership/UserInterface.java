package com.yearup.dealership;

import java.util.Scanner;

public class UserInterface {
    //Display Method controls the user interface

    public void displayMainMenu() {

//        Call the private init

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
//add display menu here
            System.out.println("Enter your command: ");
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "price search":
//                        display search by price menu
                        break;
                    case "make and model search":
//                        display search by model menu
                        break;
                    case "search by year":
//                        display search by year menu
                    case "search by color":
//                        display search by color menu
                        break;
                    case "search by mileage":
//                  display search by mileage menu
                    break;
                    case "search by vehicle type":
//                        display search by vehicle type
                        break;
                    case"search all vehicles":
                        //show all vehicles display
                        break;
                    case "add vehicle to list":
                        //show add vehicle method
                        break;
                    case"remove vehicle from list":
                        //add remove car method
                        break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }


}
