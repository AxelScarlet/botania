import bean.Farmer;
import dao.FarmerDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if session is invalid
            return; // Exit the method
        }

        String username = (String) session.getAttribute("username");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        FarmerDao farmerDao = new FarmerDao();
        Farmer farmer = farmerDao.getFarmerDetails(username); // Fetch current farmer details

        if (farmer == null) {
            request.setAttribute("error", "Farmer not found.");
            request.getRequestDispatcher("farmer_profile.jsp").forward(request, response);
            return; // Exit the method
        }

        // Check if the current password matches
        if (farmer.getPassword() != null && farmer.getPassword().equals(currentPassword)) {
            if (newPassword.equals(confirmPassword)) {
                // Update password in the database
                boolean isUpdated = farmerDao.updatePassword(username, newPassword);
                if (isUpdated) {
                    request.setAttribute("message", "Password changed successfully!");
                } else {
                    request.setAttribute("error", "Failed to update password. Please try again.");
                }
            } else {
                request.setAttribute("error", "New passwords do not match.");
            }
        } else {
            request.setAttribute("error", "Current password is incorrect.");
        }

        // Set the farmer details to be displayed on the profile page
        request.setAttribute("farmer", farmer);
        request.getRequestDispatcher("farmer_profile.jsp").forward(request, response); // Redirect back to profile page
    }
}