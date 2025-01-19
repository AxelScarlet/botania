package dao;

import bean.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

public class SupplierDao {
    
    // Method to update SUPPLIER details
    public boolean updateSupplierDetails(Supplier supplier) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean isUpdated = false;

        try {
            con = DBConnection.createConnection();
            String query = "UPDATE SUPPLIER SET FULLNAME=?, PHONENUMBER=?, ADDRESS=? WHERE USERNAME=?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getPhoneNumber());
            preparedStatement.setString(3, supplier.getAddress());
            preparedStatement.setString(4, supplier.getUsername());

            int rowsAffected = preparedStatement.executeUpdate();
            isUpdated = (rowsAffected > 0); // Check if the update was successful
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isUpdated;
    }

    // Method to get SUPPLIER details by username
    public Supplier getSupplierDetails(String username) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Supplier supplier = null;

        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM SUPPLIER WHERE USERNAME=?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                supplier = new Supplier();
                supplier.setId(resultSet.getInt("SUPPLIERID"));
                supplier.setUsername(resultSet.getString("USERNAME"));
                supplier.setName(resultSet.getString("FULLNAME"));
                supplier.setPhoneNumber(resultSet.getString("PHONENUMBER"));
                supplier.setAddress(resultSet.getString("ADDRESS"));
                supplier.setPassword(resultSet.getString("PASSWORD")); // Correctly set the password
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return supplier;
    }
    
    // Method to update user password
    public boolean updatePassword(String username, String newPassword) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean isUpdated = false;

        try {
            con = DBConnection.createConnection();
            String query = "UPDATE SUPPLIER SET PASSWORD=? WHERE USERNAME=?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);

            int rowsAffected = preparedStatement.executeUpdate();
            isUpdated = (rowsAffected > 0); // Check if the update was successful
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isUpdated;
    }
}