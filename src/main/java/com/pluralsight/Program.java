package com.pluralsight;

public class Program {
    public static void main(String[] args) {
        Dealership dealership = DealershipFileManager.loadDealership();
        if (dealership == null) {
            System.out.println("Failed to load dealership data.");
            return;
        }
        UserInterface ui = new UserInterface(dealership);
        ui.start();
    }
}
