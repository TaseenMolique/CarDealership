package com.pluralsight;

import java.io.*;

public class ContractFileManager {
    private static final String filePath = "Contracts.csv";

    public static void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(contract.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}
