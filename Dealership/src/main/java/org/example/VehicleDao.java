package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private final String connectionString;
    private final String userName;
    private final String password;

    public VehicleDao(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    public List<Vehicle> getall() {
        List<Vehicle> list = new ArrayList<>();
        String query = "Select * From vehicles";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            //loop through rows until you run out
            while (rs.next()) {
                //how do we grab the data from sql?
                Vehicle newVehicle = new Vehicle();
                newVehicle.setVin(rs.getInt("Vin_number"));
                newVehicle.setMake(rs.getString("vehicle_make"));
                newVehicle.setVehicleType(VehicleType.valueOf(rs.getString("vehicle_type")));
                newVehicle.setModel(rs.getString("vehicle_model"));
                newVehicle.setYear(rs.getInt("vehicle_year"));
                newVehicle.setPrice(rs.getInt("Vin_number"));
                newVehicle.setColor(rs.getString("Vin_number"));
                newVehicle.setOdometer(rs.getInt("odometer"));


                if (!rs.getBoolean("sold") && !rs.getBoolean("leased")) {
                    list.add(newVehicle);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return list;

    }

    public void delete(int Vin_number) {
        String query = "Delete from Vehicle where Vin_number =? ";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, Vin_number);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    //create
    public void create(Vehicle vehicle) {
        String query = "Insert INTO vehicles (Vin_number, vehicle_make, vehicle_type, vehicle_model, vehicle_year, price, sold, leased, vehicle_color, odometer) values(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, vehicle.getVin());
            stmt.setString(2, vehicle.getMake());
            stmt.setString(3, (vehicle.getVehicleType().toString()));
            stmt.setString(4, vehicle.getModel());
            stmt.setInt(5, vehicle.getYear());
            stmt.setDouble(6, vehicle.getPrice());
            stmt.setInt(7, 0);
            stmt.setInt(8, 0);
            stmt.setString(9, vehicle.getColor());
            stmt.setInt(10, vehicle.getOdometer());

            //etc.remeber, you dont need to set id,let sql do it
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }


    public List<Vehicle> getVehicleByPrice(double min, double max) {
        String qurey = "Select * from vehicles where price between ? and ?";
        List<Vehicle> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(qurey)) {
            stmt.setDouble(1, min);
            stmt.setDouble(2, max);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin_number"));
                    newVehicle.setMake(rs.getString("vehicle_make"));
                    newVehicle.setVehicleType(VehicleType.valueOf(rs.getString("vehicle_type")));
                    newVehicle.setModel(rs.getString("vehicle_model"));
                    newVehicle.setYear(rs.getInt("vehicle_year"));
                    newVehicle.setPrice(rs.getInt("Vin_number"));
                    newVehicle.setColor(rs.getString("Vin_number"));
                    newVehicle.setOdometer(rs.getInt("odometer"));

                    if (!rs.getBoolean("sold") && !rs.getBoolean("leased")) {
                        list.add(newVehicle);
                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Vehicle> getVehicleBymakeandmodel(String make, String model) {
        String qurey = "Select * from vehicles where Vehicle_make=? and Vehicle_model=?";
        List<Vehicle> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(qurey)) {
            stmt.setString(1, make);
            stmt.setString(2, model);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin_number"));
                    newVehicle.setMake(rs.getString("vehicle_make"));
                    newVehicle.setVehicleType(VehicleType.valueOf(rs.getString("vehicle_type")));
                    newVehicle.setModel(rs.getString("vehicle_model"));
                    newVehicle.setYear(rs.getInt("vehicle_year"));
                    newVehicle.setPrice(rs.getInt("Vin_number"));
                    newVehicle.setColor(rs.getString("Vin_number"));
                    newVehicle.setOdometer(rs.getInt("odometer"));

                    if (!rs.getBoolean("sold") && !rs.getBoolean("leased")) {
                        list.add(newVehicle);
                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Vehicle> getVehicleByyear(int year,int yearMax) {
        String qurey = "Select * from vehicles where vehicle year between ? and ?";
        List<Vehicle> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(qurey)) {
            stmt.setInt(1, year);
            stmt.setInt(2, yearMax);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin_number"));
                    newVehicle.setMake(rs.getString("vehicle_make"));
                    newVehicle.setVehicleType(VehicleType.valueOf(rs.getString("vehicle_type")));
                    newVehicle.setModel(rs.getString("vehicle_model"));
                    newVehicle.setYear(rs.getInt("vehicle_year"));
                    newVehicle.setPrice(rs.getInt("Vin_number"));
                    newVehicle.setColor(rs.getString("Vin_number"));
                    newVehicle.setOdometer(rs.getInt("odometer"));

                    if (!rs.getBoolean("sold") && !rs.getBoolean("leased")) {
                        list.add(newVehicle);
                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Vehicle> getVehicleByColor(String color) {
        String qurey = "Select * from vehicles where Vehicle_color=?";
        List<Vehicle> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(qurey)) {
            stmt.setString(1, color);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin_number"));
                    newVehicle.setMake(rs.getString("vehicle_make"));
                    newVehicle.setVehicleType(VehicleType.valueOf(rs.getString("vehicle_type")));
                    newVehicle.setModel(rs.getString("vehicle_model"));
                    newVehicle.setYear(rs.getInt("vehicle_year"));
                    newVehicle.setPrice(rs.getInt("Vin_number"));
                    newVehicle.setColor(rs.getString("Vin_number"));
                    newVehicle.setOdometer(rs.getInt("odometer"));

                    if (!rs.getBoolean("sold") && !rs.getBoolean("leased")) {
                        list.add(newVehicle);
                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public List<Vehicle> getVehicleByOdometer(int odometer ,int OdometerMax) {
        String qurey = "Select * from vehicles where Odometer between ? and ?";
        List<Vehicle> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(qurey)) {
            stmt.setInt(1, odometer);
            stmt.setInt(2, OdometerMax);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin_number"));
                    newVehicle.setMake(rs.getString("vehicle_make"));
                    newVehicle.setVehicleType(VehicleType.valueOf(rs.getString("vehicle_type")));
                    newVehicle.setModel(rs.getString("vehicle_model"));
                    newVehicle.setYear(rs.getInt("vehicle_year"));
                    newVehicle.setPrice(rs.getInt("Vin_number"));
                    newVehicle.setColor(rs.getString("Vin_number"));
                    newVehicle.setOdometer(rs.getInt("odometer"));

                    if (!rs.getBoolean("sold") && !rs.getBoolean("leased")) {
                        list.add(newVehicle);
                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public List<Vehicle> getVehicleByType(String vehicle_Type) {
        String qurey = "Select * from vehicles where Vehicle_type=?";
        List<Vehicle> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(qurey)) {
            stmt.setString(1, vehicle_Type);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("Vin_number"));
                    newVehicle.setMake(rs.getString("vehicle_make"));
                    newVehicle.setVehicleType(VehicleType.valueOf(rs.getString("vehicle_type")));
                    newVehicle.setModel(rs.getString("vehicle_model"));
                    newVehicle.setYear(rs.getInt("vehicle_year"));
                    newVehicle.setPrice(rs.getInt("Vin_number"));
                    newVehicle.setColor(rs.getString("Vin_number"));
                    newVehicle.setOdometer(rs.getInt("odometer"));

                    if (!rs.getBoolean("sold") && !rs.getBoolean("leased")) {
                        list.add(newVehicle);
                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}





