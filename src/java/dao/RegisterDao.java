package dao;

import util.DBConnection;
import bean.registerBean;
import java.sql.*;

public class RegisterDao {
    public String registerUser(registerBean registerBean, String role) {
        String username = registerBean.getUsername();
        String name = registerBean.getName();
        String phoneNumber = registerBean.getPhoneNumber();
        String address = registerBean.getAddress();
        String password = registerBean.getPassword();

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBConnection.createConnection();
            String table = role.equals("farmer") ? "FARMER" : "SUPPLIER";
            String idColumn = role.equals("farmer") ? "FARMERID" : "SUPPLIERID";

            String query = "INSERT INTO " + table + " (" + idColumn + ", USERNAME, FULLNAME, PHONENUMBER, ADDRESS, PASSWORD) VALUES (?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, getNextId(con, table, idColumn));
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, password);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Registration failed";
    }

    private int getNextId(Connection con, String table, String idColumn) throws SQLException {
        String query = "SELECT MAX(" + idColumn + ") AS max_id FROM " + table;
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("max_id") + 1;
            }
        }
        return 1; // Default to 1 if no records found
    }
}
