package org.example;

public class LeaseContract extends Contract {
    private double endingValue;
    private double leaseFee;
    private double monthlyPayment;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
        endingValue=0.50*vehicle.getPrice();
        leaseFee=0.07*vehicle.getPrice();
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double  valueDecline= getVehicle().getPrice() - endingValue;
        double moneyFactor = 0.04 / 24;
        monthlyPayment = (valueDecline / 36) + ((getVehicle().getPrice() + endingValue) * moneyFactor);
        return monthlyPayment;}



    @Override
    public double getTotalPrice() {
        return getMonthlyPayment() * 36 + leaseFee;
}


    @Override
    public String toString() {
        return
                "|" + endingValue +
                "|" + leaseFee +
                "|" + monthlyPayment;
    }
}
