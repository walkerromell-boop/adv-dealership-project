package com.yearup.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public List<Vehicle> getVehicleByPrice(double minPrice, double maxPrice) {
        List<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                filtered.add(v);
            }
        }
        return filtered;
    }

    public List<Vehicle> getVehicleByMakeModel(String search) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getMake().toLowerCase().contains(search.toLowerCase()) ||
                    v.getModel().toLowerCase().contains(search.toLowerCase())) {
                results.add(v);
            }
        }
        return results;
    }

    public List<Vehicle> getVehicleByColor(String color) {
        List<Vehicle> filtered = new ArrayList<>();
        return null;
    }

    public List<Vehicle> getVehicleByYear(int minYear, int max) {
        List<Vehicle> filtered = new ArrayList<>();
        return null;
    }

    public List<Vehicle> getVehicleByMileage(int minMiles, int maxMiles) {
        List<Vehicle> filtered = new ArrayList<>();
        return null;
    }

    public List<Vehicle> getVehicleByType(double minPrice, double maxPrice) {
        List<Vehicle> filtered = new ArrayList<>();
        return null;
    }

    public List<Vehicle> getAllVehicles() {
//        List<Vehicle> filtered = new ArrayList<>();
        return vehicles;
    }

    public void addVehicle(Vehicle newVehicles) {
        vehicles.add(newVehicles);

    }

    public List<Vehicle> removeVehicle() {
        List<Vehicle> filtered = new ArrayList<>();
        return null;
    }


}


