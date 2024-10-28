package com.pluralsight;

import java.io.*;

public class DealershipFileManager {
    private static final String filePath = "Vehicles.csv";

    public static Dealership loadDealership() {
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))){
            String[] dealershipInfo = bf.readLine().split("\\|");
            Dealership dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);
            String line;
            while ((line = bf.readLine()) != null) {
                String[] vehicleData = line.split("\\|");
                Vehicle vehicle = new Vehicle(
                        Integer.parseInt(vehicleData[0]),
                        Integer.parseInt(vehicleData[1]),
                        vehicleData[2],
                        vehicleData[3],
                        vehicleData[4],
                        vehicleData[5],
                        Integer.parseInt(vehicleData[6]),
                        Double.parseDouble(vehicleData[7])
                );
                dealership.addVehicle(vehicle);
            }
            return dealership;
        } catch (FileNotFoundException fnfe){
            System.out.println("File now foundL " + filePath);
            return new Dealership("Default Dealership", "N/A", "N/A");
        } catch (Exception e) {
            System.out.println("Error loading dealership data." + e.getMessage());
            return null;
        }
    }

    public  static void saveDealership(Dealership dealership){
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");
            for (Vehicle vehicle : dealership.listAllVehicles()){
                writer.write(vehicle.toString() + "\n");
            }
        } catch (IOException ioex) {
            System.out.println("Error saving dealership data.");
        }
    }

}
