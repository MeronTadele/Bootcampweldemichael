package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SalesContractTest {
    @Test

    public void isSold_isFinaced() {
        Vehicle vehicle = new Vehicle(200, 2012, "toyota", "sudan", VehicleType.valueOf("van"), "gray", 34000, 300);
        SalesContract salesContract = new SalesContract("2024-1", "mary", "mer@gmail.com", vehicle, true);
        double sales = salesContract.getMonthlyPayment();
        assertEquals(26.82, sales);

    }
}