package com.yearup.dealership;

import java.io.FileNotFoundException;

public class Program {
    public static void main(String[] args)  {
//        DealershipFileManger fileManger=new DealershipFileManger();
//        Dealership dealership= fileManger.getDealership();
//
//        System.out.println("Dealership: "+ dealership.getName());
//        dealership.getVehicleByPrice(10000,20000);

        UserInterface userInterface = new UserInterface();
        userInterface.displayMainMenu();

    }
}
