package com.pluralsight;

import java.util.Scanner;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;
    private static final double leaseRate = 0.04;

    public LeaseContract(String contractType, String contractDate, String customerName, String customerEmail, Vehicle vehicle) {
        super(contractType, contractDate, customerName, customerEmail, vehicle);
        this.expectedEndingValue = vehicle.getPrice() * 0.5;
        this.leaseFee = vehicle.getPrice() * 0.07;
    }

    public void collectLeaseInfo() {
        Scanner scanner = new Scanner(System.in);
        int vehicleAge = 2023 - vehicle.getYear();
        if (vehicleAge > 3) {
            System.out.println("Cannot lease a vehicle over 3 years old. Please select a different vehicle.");
            return;
        }

        totalPrice = expectedEndingValue + leaseFee;
        calculateMonthlyPayment();
    }

    @Override
    public void calculatePrice() {

    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    private void calculateMonthlyPayment() {
        monthlyPayment = (totalPrice * (1 + leaseRate)) / 36;
    }

}
