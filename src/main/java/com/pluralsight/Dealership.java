package com.pluralsight;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private Vehicle[] vehicles;
    private int vehicleCount;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new Vehicle[100];
        this.vehicleCount = 0;
    }

    public void addVehicle(Vehicle vehicle){
        if (vehicleCount < vehicles.length) {
            vehicles[vehicleCount++] = vehicle;
        } else {
            System.out.println("Cannot add more vehicles, the list is full.");
        }
    }

    public void removeVehicle(int id) {
        for (int i = 0 ; i < vehicleCount; i++) {
            if (vehicles[1].getId() == id){
                vehicles[1] = vehicles[vehicleCount - 1];
                vehicles[vehicleCount - 1] = null;
                vehicleCount--;
                return;
            }
        }
        System.out.println("Vehicle was not found");
    }

    public Vehicle[] findByPriceRange(double min, double max) {
        Vehicle[] result = new Vehicle[vehicleCount];
        int resultCount = 0;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getPrice() >= min && vehicles[i].getPrice() <= max) {
                result[resultCount++] = vehicles[i];
            }
        }
        return trimArray(result, resultCount);
    }

    public Vehicle[] findByMakeModel(String make, String model) {
        Vehicle[] result = new Vehicle[vehicleCount];
        int resultCount = 0;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getMake().equalsIgnoreCase(make) && vehicles[i].getModel().equalsIgnoreCase(model)) {
                result[resultCount++] = vehicles[i];
            }
        }
        return trimArray(result, resultCount);
    }

    public Vehicle[] findByYearRange(int startYear, int endYear) {
        Vehicle[] result = new Vehicle[vehicleCount];
        int resultCount = 0;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getYear() >= startYear && vehicles[i].getYear() <= endYear) {
                result[resultCount++] = vehicles[i];
            }
        }
        return trimArray(result, resultCount);
    }

    public Vehicle[] findByColor(String color) {
        Vehicle[] result = new Vehicle[vehicleCount];
        int resultCount = 0;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getColor().equalsIgnoreCase(color)) {
                result[resultCount++] = vehicles[i];
            }
        }
        return trimArray(result, resultCount);
    }

    public Vehicle[] findByMileageRange(int min, int max) {
        Vehicle[] result = new Vehicle[vehicleCount];
        int resultCount = 0;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getMileage() >= min && vehicles[i].getMileage() <= max) {
                result[resultCount++] = vehicles[i];
            }
        }
        return trimArray(result, resultCount);
    }

    public Vehicle[] findByType(String type) {
        Vehicle[] result = new Vehicle[vehicleCount];
        int resultCount = 0;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getType().equalsIgnoreCase(type)) {
                result[resultCount++] = vehicles[i];
            }
        }
        return trimArray(result, resultCount);
    }

    public Vehicle[] listAllVehicles() {
        return trimArray(vehicles, vehicleCount);
    }

    private Vehicle[] trimArray(Vehicle[] array, int length) {
        Vehicle[] trimmed = new Vehicle[length];
        System.arraycopy(array, 0, trimmed, 0, length);
        return trimmed;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}


}
