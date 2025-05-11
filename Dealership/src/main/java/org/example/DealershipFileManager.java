package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class DealershipFileManager {
    public  Dealership getDealership() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/vehicles.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Dealership dealership;
            String[] added = bufferedReader.readLine().split("\\|");
            String name = added[0];
            String address = added[1];
            String phone = added[2];
            dealership = new Dealership(name, address, phone);

            bufferedReader.readLine();
            String input;

            while ((input = bufferedReader.readLine()) != null) {
                String[] add = input.split("\\|");
                int vin = Integer.parseInt(add[0]);
                int year = Integer.parseInt(add[1]);
                String make = add[2];
                String model = add[3];
                VehicleType vehicleType = VehicleType.valueOf(add[4]);//converting to string
                String color = add[5];
                int odometer = Integer.parseInt(add[6]);
                double price = Double.parseDouble(add[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            bufferedReader.close();
            return dealership;
        } catch (IOException ex) {
            System.out.println("failed to load");

            return null;

        }
    }
        public static void writeFile(List<Vehicle> VehicleList) {
            try {
                FileWriter fileWriter = new FileWriter("src/main/resources/vehicles.csv");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Write product rows
                for (Vehicle vehicle : VehicleList) {
                    String line = vehicle.getVin() + "|" +
                            vehicle.getYear() + "|" +
                            vehicle.getMake() + "|" +
                            vehicle.getModel() + "|" +
                            vehicle.getVehicleType() + "|" +
                            vehicle.getColor() + "|" +
                            vehicle.getOdometer() + "|" +
                            vehicle.getPrice() + "|";
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }

                // Close the writer
                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println("Failed to write to csv file.");
                ex.printStackTrace();
            }
        }


    public void saveDealership(Dealership dealership){

    }

    }

