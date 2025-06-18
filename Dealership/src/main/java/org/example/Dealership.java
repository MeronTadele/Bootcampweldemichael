package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;
    private VehicleDao vehicleDao;
    private SaleDao saleDao;
    private LeaseDao leaseDao;


    public Dealership( String []args) {

        this.vehicles = vehicles;
        this.vehicleDao = new VehicleDao("jdbc:mysql://localhost:3307/cardealership" , args[0] ,args[1]);
        this.saleDao = new SaleDao("jdbc:mysql://localhost:3307/cardealership" , args[0] ,args[1]);
        this.leaseDao = new LeaseDao("jdbc:mysql://localhost:3307/cardealership" , args[0] ,args[1]);
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

    public VehicleDao getVehicleDao() {
        return vehicleDao;
    }

    public void setVehicleDao(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public LeaseDao getLeaseDao() {
        return leaseDao;
    }

    public void setLeaseDao(LeaseDao leaseDao) {
        this.leaseDao = leaseDao;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {


        return vehicleDao.getVehicleByPrice(min, max);
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {


        return vehicleDao.getVehicleBymakeandmodel(make,model);
    }


    public List<Vehicle> getVehiclesByYear(int min, int max) {

        return vehicleDao.getVehicleByyear(min , max);
    }


    public List<Vehicle> getVehiclesByColor(String color) {


        return vehicleDao.getVehicleByColor(color);
    }


    public List<Vehicle> getVehiclesByMileage(int min, int max) {

        return vehicleDao.getVehicleByOdometer(min,max);
    }

    public List<Vehicle> getVehiclesByVehicleType(VehicleType vehicleType) {

        return vehicleDao.getVehicleByType(vehicleType.toString());
    }


    public List<Vehicle> getAllVehicles() {

        return vehicleDao.getall();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleDao.create(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {

       vehicleDao.delete(vehicle.getVin());
    }

    public void getSaleOrLeaseVehicle(int choice, int vin, String name, String email, int finance) {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vin == vehicle.getVin()) {
                if (choice == 1) {
                    SalesContract salesContract;
                    if (finance == 1) {
                        String date = String.valueOf(LocalDate.now());
                        salesContract = new SalesContract(date, name, email, vehicle, true);
                        saleDao.create(salesContract);
                        System.out.println("Vehicle sold:" + salesContract);
                    } else if (finance == 2) {
                        String date = String.valueOf(LocalDate.now());
                        salesContract = (new SalesContract(date, name, email, vehicle, false));
                        saleDao.create(salesContract);
                        System.out.println("Vehicle sold:" + salesContract);
                    }
                    saleDao.update(vin);
                    break;}
                    else if (choice == 2) {
                        String date = String.valueOf(LocalDate.now());
                      LeaseContract  leaseContract=(new LeaseContract(date, name, email, vehicle));
                      leaseDao.create(leaseContract);
                      leaseDao.update(vin);
                    System.out.println("Vehicle Leased"+ leaseContract);
                        break;
                    }
            } else if (vin != vehicle.getVin() && i + 1 == vehicles.size()) {
                System.out.println("Enter the right vin number");
            }
        }
    }
}


