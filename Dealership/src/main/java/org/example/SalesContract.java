package org.example;

public class SalesContract extends Contract{
    private double taxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;
    private double monthlyPayment;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, double taxAmount, double recordingFee, double processingFee, boolean isFinanced, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicle);
        this.taxAmount = taxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.isFinanced = isFinanced;
        this.monthlyPayment = monthlyPayment;
    }

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicle);
        taxAmount=0.05* vehicle.getPrice();
        recordingFee=100;
        if (vehicle.getPrice()<=10000){
            processingFee=295;
        }else {
            processingFee=495;
        }
        this.isFinanced=isFinanced;

    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double  getTotalPrice() {
        return getVehicle().getPrice()  + getTaxAmount() + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        if (isFinanced==true) {
            double monthlyIntersetRate;
            int months;
            if (getVehicle().getPrice() >= 10000) {
                monthlyIntersetRate = (4.25 / 12) / 100;        months = 48;    }
            else {        monthlyIntersetRate= (5.25 / 12) / 100;        months = 24;    }
            monthlyPayment= getTotalPrice() * (Math.abs(monthlyIntersetRate* Math.pow(1 + monthlyIntersetRate, months))/
              Math.abs(Math.pow(1 + monthlyIntersetRate, months) - 1));
            return monthlyPayment;}
        else {
            return 0;}

    }


    public String toString1() {
        return
                "|" + taxAmount +
                "|"+ recordingFee +
                "|" + processingFee +
                "|" + isFinanced +
                "|" + monthlyPayment;
    }
}
