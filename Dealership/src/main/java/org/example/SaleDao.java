package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaleDao {
    private final String connectionString;
    private final String userName;
    private final String password;

    public void SaleDao(){

    }

    public SaleDao(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }
    public void update(int Vin_number){
        String qurey="Update Vehicles set sold=?, where Vin_number=?";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(qurey)) {
            //replace? with actual date
            stmt.setBoolean(1,true);
            stmt.setInt(2,  Vin_number);

            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void create(SalesContract salesContract) {
        String query = "Insert INTO sales_contracts (vin_number, Name, Email_address, Address, phone, date, ProcessingFee, TaxAmount, Financed, Total_price, Monthly_Payment values(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, salesContract.getVehicle().getVin());
            stmt.setString(2, salesContract.getCustomerName());
            stmt.setString(3, salesContract.getCustomerEmail());
            stmt.setString(4, null);
            stmt.setString(5, null);
            stmt.setString(6, salesContract.getDate());
            stmt.setDouble(7, salesContract.getProcessingFee());
            stmt.setDouble(8, salesContract.getTaxAmount());
            stmt.setBoolean(9, salesContract.isFinanced());
            stmt.setDouble(10, salesContract.getTotalPrice());
            stmt.setDouble(10, salesContract.getMonthlyPayment());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
}
