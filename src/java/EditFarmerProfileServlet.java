import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.FarmerDao; // Assuming you have a DAO class for Farmer
import bean.Farmer;

@WebServlet("/EditFarmerProfileServlet")
public class EditFarmerProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the profile page to show the current details
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            FarmerDao farmerDao = new FarmerDao();
            Farmer farmer = farmerDao.getFarmerDetails(username); // Fetch current farmer details
            request.setAttribute("farmer", farmer);
            request.getRequestDispatcher("farmer_profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login if session is invalid
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the updated details from the form
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");

        // Get the username from the session
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");

        // Create a Farmer object to hold the updated details
        Farmer farmer = new Farmer();
        farmer.setUsername(username);
        farmer.setName(fullName);
        farmer.setPhoneNumber(phoneNumber);
        farmer.setAddress(address);

        // Update the farmer's details in the database
        FarmerDao farmerDao = new FarmerDao();
        boolean isUpdated = farmerDao.updateFarmerDetails(farmer);

        if (isUpdated) {
            // Redirect back to the profile page with a success message
            request.setAttribute("successMessage", "Profile updated successfully.");
            request.setAttribute("farmer", farmer); // Set updated farmer details
            request.getRequestDispatcher("farmer_profile.jsp").forward(request, response);
        } else {
            // Handle the case where the update fails
            request.setAttribute("errorMessage", "Failed to update profile. Please try again.");
            request.getRequestDispatcher("farmer_profile.jsp").forward(request, response);
        }
    }
}