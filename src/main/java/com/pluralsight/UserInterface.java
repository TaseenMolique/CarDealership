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
            System.out.println("10. Create a contract");
            System.out.println("0. Quit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    findByPriceRange();
                    break;
                case 2:
                    findByMakeModel();
                    break;
                case 3:
                    findByYearRange();
                    break;
                case 4:
                    findByColor();
                    break;
                case 5:
                    findByMileageRange();
                    break;
                case 6:
                    findByType();
                    break;
                case 7:
                    listAllVehicles();
                    break;
                case 8:
                    addVehicle();
                    break;
                case 9:
                    removeVehicle();
                    break;
                case 10:
                    createContract();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void findByPriceRange() {
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        Vehicle[] vehicles = dealership.findByPriceRange(min, max);
        displayVehicles(vehicles);
    }

    private void findByMakeModel() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        Vehicle[] vehicles = dealership.findByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void findByYearRange() {
        System.out.print("Enter start year: ");
        int startYear = scanner.nextInt();
        System.out.print("Enter end year: ");
        int endYear = scanner.nextInt();
        Vehicle[] vehicles = dealership.findByYearRange(startYear, endYear);
        displayVehicles(vehicles);
    }

    private void findByColor() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        Vehicle[] vehicles = dealership.findByColor(color);
        displayVehicles(vehicles);
    }

    private void findByMileageRange() {
        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();
        Vehicle[] vehicles = dealership.findByMileageRange(min, max);
        displayVehicles(vehicles);
    }

    private void findByType() {
        System.out.print("Enter type (car, truck, SUV, or van): ");
        String type = scanner.nextLine();
        Vehicle[] vehicles = dealership.findByType(type);
        displayVehicles(vehicles);
    }

    private void listAllVehicles() {
        Vehicle[] vehicles = dealership.listAllVehicles();
        displayVehicles(vehicles);
    }

    private void addVehicle() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Mileage: ");
        int mileage = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(id, year, make, model, type, color, mileage, price);
        dealership.addVehicle(vehicle);
        System.out.println("Added vehicle successfully!");
    }

    private void removeVehicle() {
        System.out.print("Enter Vehicle ID to remove: ");
        int id = scanner.nextInt();
        dealership.removeVehicle(id);
        System.out.println("Removed vehicle successfully");
    }

    private void displayVehicles(Vehicle[] vehicles) {
        if (vehicles.length == 0 || vehicles[0] == null) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                if (v != null) {
                    System.out.println(v);
                }
            }
        }
    }

    private void createContract() {
        System.out.println("Select contract type: ");
        System.out.println("1. Lease Contract");
        System.out.println("2. Sales Contract");
        System.out.println("Enter a choice: ");
        int contractChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter contract type: ");
        String contractType = scanner.nextLine();
        System.out.print("Enter contract date: ");
        String contractDate = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        Vehicle vehicle = selectVehicle();

        Contract contract;
        if (contractChoice == 1) {
            contract = new LeaseContract(contractType, contractDate, customerName, customerEmail, vehicle);
        } else {
            contract = new SalesContract(contractType, contractDate, customerName, customerEmail, vehicle);
        }

        if (contractChoice == 1) {
            ((LeaseContract) contract).collectLeaseInfo();
        } else {
            ((SalesContract) contract).collectsSalesInfo();
        }

        ContractFileManager.saveContract(contract);
        System.out.println("Contract created successfully!");
    }

    private Vehicle selectVehicle() {
        System.out.print("Enter Vehicle ID to select: ");
        int id = scanner.nextInt();
        Vehicle vehicle = dealership.getVehicleById(id);
        if (vehicle == null) {
            System.out.println("No vehicle found with ID: " + id);
            return selectVehicle();
        }
        return vehicle;
    }
}
