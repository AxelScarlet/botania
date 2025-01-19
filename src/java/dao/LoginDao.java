package dao;
import bean.Farmer;
import bean.Supplier;
import bean.LoginBean;
import java.sql.*;
import util.DBConnection;

public class LoginDao {
    public String authenticateUser(LoginBean loginBean) {
        String userName = loginBean.getUsername();
        String password = loginBean.getPassword();
        
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String role = "Invalid user credentials";

        try {
            con = DBConnection.createConnection();

            // Check in FARMER table
            if (checkUser(con, "FARMER", userName, password)) {
                return "farmer";
            }

            // Check in SUPPLIER table
            if (checkUser(con, "SUPPLIER", userName, password)) {
                return "supplier";
            }

            // Check in ADMIN table
            if (checkUser(con, "ADMIN", userName, password)) {
                return "admin";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return role;
    }

    private boolean checkUser(Connection con, String tableName, String userName, String password) throws SQLException {
        String query = "SELECT username, password FROM " + tableName + " WHERE username=? AND password=?";
        
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return true;
        }
        return false;
    }
    
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return farmer;
    }
    
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return supplier;
    }
}
