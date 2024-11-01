package com.pluralsight;

import java.util.Scanner;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee = 100.0;
    private double processingFee;
    private boolean financing;
    private static final double loanRateAbove10000 = 0.0425;
    private static final double loanRateBelow10000 = 0.0525;

    public SalesContract(String contractType, String contractDate, String customerName, String customerEmail, Vehicle vehicle) {
        super(contractType, contractDate, customerName, customerEmail, vehicle);
    }

    public void collectsSalesInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the vehicle price: ");
        double price = scanner.nextDouble();
        System.out.println("Financing (yes/no)? ");
        financing = scanner.next().equalsIgnoreCase("yes");

        processingFee = (price < 10000) ? 495.0 : 295.0;

        salesTax = price * 0.05;
        totalPrice = price + salesTax + recordingFee + processingFee;
        calculateMonthlyPayment(price);
    }

    @Override
    public void calculatePrice(){
        //Price calculation is run b collectSaleInfo
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment(){
        return financing ? monthlyPayment : 0;
    }

    private void calculateMonthlyPayment(double price){
        if (financing) {
            if (price >= 10000) {
                monthlyPayment = (price * (1 + loanRateAbove10000) / 48);
            } else {
                monthlyPayment = (price * (1 + loanRateBelow10000) / 24);
            }
        } else {
            monthlyPayment = 0;
        }
    }
}
