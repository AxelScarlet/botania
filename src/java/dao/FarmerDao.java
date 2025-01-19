package dao;

import bean.Farmer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

public class FarmerDao {
    
    // Method to update farmer details
    public boolean updateFarmerDetails(Farmer farmer) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean isUpdated = false;

        try {
            con = DBConnection.createConnection();
            String query = "UPDATE FARMER SET FULLNAME=?, PHONENUMBER=?, ADDRESS=? WHERE USERNAME=?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, farmer.getName());
            preparedStatement.setString(2, farmer.getPhoneNumber());
            preparedStatement.setString(3, farmer.getAddress());
            preparedStatement.setString(4, farmer.getUsername());

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

    // Method to get farmer details by username
    public Farmer getFarmerDetails(String username) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Farmer farmer = null;

        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM FARMER WHERE USERNAME=?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                farmer = new Farmer();
                farmer.setId(resultSet.getInt("FARMERID"));
                farmer.setUsername(resultSet.getString("USERNAME"));
                farmer.setName(resultSet.getString("FULLNAME"));
                farmer.setPhoneNumber(resultSet.getString("PHONENUMBER"));
                farmer.setAddress(resultSet.getString("ADDRESS"));
                farmer.setPassword(resultSet.getString("PASSWORD")); // Correctly set the password
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
        return farmer;
    }
    
    // Method to update user password
    public boolean updatePassword(String username, String newPassword) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean isUpdated = false;

        try {
            con = DBConnection.createConnection();
            String query = "UPDATE FARMER SET PASSWORD=? WHERE USERNAME=?";
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