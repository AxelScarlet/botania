package dao;

import bean.Complaint; // Assuming you have a Complaint class
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.DBConnection;

public class ComplaintDao {
    
    // Method to save a complaint
    public boolean saveComplaint(Complaint complaint) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        boolean isSaved = false;

        try {
            con = DBConnection.createConnection();
            String query = "INSERT INTO COMPLAINTS (TITLE, DESCRIPTION, USERNAME) VALUES (?, ?, ?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, complaint.getTitle());
            preparedStatement.setString(2, complaint.getDescription());
            preparedStatement.setString(3, complaint.getUsername());

            // Debugging output
            System.out.println("Inserting complaint: " + complaint.getTitle() + ", " + complaint.getDescription() + ", " + complaint.getUsername());

            int rowsAffected = preparedStatement.executeUpdate();
            isSaved = (rowsAffected > 0); // Check if the insert was successful
            System.out.println("Rows affected: " + rowsAffected); // Debugging output
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSaved;
    }
}