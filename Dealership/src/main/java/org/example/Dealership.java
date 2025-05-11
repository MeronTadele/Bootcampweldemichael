package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>(); // because it is objecte
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles1=new ArrayList<>();// will create new list
        for (int i = 0; i < vehicles.size(); i++) {
         Vehicle vehicle2 =  vehicles.get(i);
         if(vehicle2.getPrice()>=min && vehicle2.getPrice()<=max){
             vehicles1.add(vehicles.get(i));
         }


        }
        return vehicles1;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicles1 = new ArrayList<>();// will create new list
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle2 = vehicles.get(i);
            if (vehicle2.getMake().equalsIgnoreCase(make) && vehicle2.getModel().equalsIgnoreCase(model)){
                vehicles1.add(vehicles.get(i));
            }
            }
            return vehicles1;
        }


    public List<Vehicle> getVehiclesByYear(double min, double max){
            List<Vehicle> vehicles1 = new ArrayList<>();// will create new list
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle vehicle2 = vehicles.get(i);
                if (vehicle2.getYear() >= min && vehicle2.getYear() <= max) {
                    vehicles1.add(vehicles.get(i));

                }
            }
                return vehicles1;
            }


    public List<Vehicle> getVehiclesByColor(String color){
                List<Vehicle> vehicles1 = new ArrayList<>();// will create new list
                for (int i = 0; i < vehicles.size(); i++) {
                    Vehicle vehicle2 = vehicles.get(i);
                    if (vehicle2.getColor().equalsIgnoreCase(color)) {
                        vehicles1.add(vehicles.get(i));


                    }
                }
                    return vehicles1;
                }


    public List<Vehicle> getVehiclesByMileage(double min, double max) {
                    List<Vehicle> vehicles1=new ArrayList<>();// will create new list
                    for (int i = 0; i < vehicles.size(); i++) {
                        Vehicle vehicle2 =  vehicles.get(i);
                        if(vehicle2.getOdometer()>=min && vehicle2.getOdometer()<=max) {
                            vehicles1.add(vehicles.get(i));
                        }
        }
        return vehicles1;
    }

    public List<Vehicle> getVehiclesByVehicleType(VehicleType vehicleType) {
            List<Vehicle> vehicles1=new ArrayList<>();// will create new list
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle vehicle2 = vehicles.get(i);
                if (vehicle2.getVehicleType().equals(vehicleType)) {
                    vehicles1.add(vehicles.get(i));

                }
            }
        return vehicles1;
    }


    public List<Vehicle> getAllVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i);


        }
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i);


        }
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        for (int i = 0; i < vehicles.size(); i++) {

            if (vehicles.get(i).equals(vehicle)) {

                vehicles.remove(vehicle);
            }

        }
    }
}
