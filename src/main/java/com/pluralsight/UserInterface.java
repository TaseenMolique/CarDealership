package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private final Dealership dealership;
    private final Scanner scanner;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Find vehicles within a price range");
            System.out.println("2. Find vehicles by make/model");
            System.out.println("3. Find vehicles by year range");
            System.out.println("4. Find vehicles by color");
            System.out.println("5. Find vehicles by mileage range");
            System.out.println("6. Find vehicles by type");
            System.out.println("7. List all vehicles");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("0. Quit");
            System.out.println("Please select an option");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){

            }

        }
    }

    private void findByPriceRange() {
        System.out.println("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.println("Enter maximum price: ");
        double max = scanner.nextDouble();
        Vehicle[] vehicles = dealership.findByPriceRange(min, max);
        displayVehicles(vehicles);
    }

    private void findByMakeModel() {
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        Vehicle[] vehicles = dealership.findByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void findByYearRange() {
        System.out.println("Enter start year: ");
        int startYear = scanner.nextInt();
        System.out.println("Enter end year: ");
        int endYear = scanner.nextInt();
        Vehicle[] vehicles = dealership.findByYearRange(startYear, endYear);
        displayVehicles(vehicles);
    }

    

    private void displayVehicles(Vehicle[] vehicles){
        if (vehicles.length == 0 || vehicles[0] == null){
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                if (v != null) {
                    System.out.println(v);
                }
            }
        }
    }

}
