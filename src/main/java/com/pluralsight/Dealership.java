package com.pluralsight;

import java.util.ArrayList;
import java.util.function.Predicate;

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

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(int id) {
        vehicles.removeIf(vehicle -> vehicle.getId() == id);
    }

    public Vehicle[] getVehicles() {
        return vehicles.toArray(new Vehicle[0]);
    }

    public Vehicle getVehicleById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    public Vehicle[] findByPriceRange(double min, double max) {
        return findVehicles(v -> v.getPrice() >= min && v.getPrice() <= max);
    }

    public Vehicle[] findByMakeModel(String make, String model) {
        return findVehicles(v -> v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model));
    }

    public Vehicle[] findByYearRange(int startYear, int endYear) {
        return findVehicles(v -> v.getYear() >= startYear && v.getYear() <= endYear);
    }

    public Vehicle[] findByColor(String color) {
        return findVehicles(v -> v.getColor().equalsIgnoreCase(color));
    }

    public Vehicle[] findByMileageRange(int min, int max) {
        return findVehicles(v -> v.getMileage() >= min && v.getMileage() <= max);
    }

    public Vehicle[] findByType(String type) {
        return findVehicles(v -> v.getType().equalsIgnoreCase(type));
    }

    private Vehicle[] findVehicles(Predicate<Vehicle> predicate) {
        return vehicles.stream()
                .filter(predicate)
                .toArray(Vehicle[]::new);
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }

    // Method to display vehicles
    public Vehicle[] listAllVehicles() {
        return getVehicles();
    }
}
