package com.pluralsight;

public abstract class Contract {
    protected String contractType;
    protected String contractDate;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicle;
    protected double totalPrice;
    protected double monthlyPayment;

    public abstract void calculatePrice();


    public Contract(String contractType, String contractDate, String customerName, String customerEmail, com.pluralsight.Vehicle vehicle) {
        this.contractType = contractType;
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public String toCSV() {
        return contractType + "|" + contractDate + "|" + customerName + "|" + customerEmail + "|" + vehicle.getId()
                + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getType()
                + "|" + vehicle.getColor() + "|" + vehicle.getMileage() + "|" + vehicle.getPrice() + "|" + totalPrice
                + "|" + monthlyPayment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public String getContractType(){
        return contractType;
    }

    public String getContractDate() {
        return contractDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}