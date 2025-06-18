package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
        private final String connectionString;
        private final String userName;
        private final String password;

        public void LeaseDao(){

        }

        public LeaseDao (String connectionString, String userName, String password) {
            this.connectionString = connectionString;
            this.userName = userName;
            this.password = password;
        }
        public void update(int Vin_number){
            String qurey="Update Vehicles set leased=?, where Vin_number=?";
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
        public void create(LeaseContract leaseContract) {
            String query = "Insert INTO sales_contracts ((vin_number, Name, Email_address, Address, phone, date, lease_Fee, TaxAmount, endingValue, Total_price, Monthly_Payment values(?,?,?,?,?,?,?,?,?,?,?)";
            try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, leaseContract.getVehicle().getVin());
                stmt.setString(2, leaseContract.getCustomerName());
                stmt.setString(3, leaseContract.getCustomerEmail());
                stmt.setString(4, null);
                stmt.setString(5, null);
                stmt.setString(6, leaseContract.getDate());
                stmt.setDouble(7, leaseContract.getLeaseFee());
                stmt.setDouble(8, 0);
                stmt.setDouble(9, leaseContract.getEndingValue());
                stmt.setDouble(10, leaseContract.getTotalPrice());
                stmt.setDouble(10, leaseContract.getMonthlyPayment());

                stmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        }
    }


