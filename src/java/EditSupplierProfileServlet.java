import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.SupplierDao; // Assuming you have a DAO class for supplier
import bean.Supplier;

@WebServlet("/EditSupplierProfileServlet")
public class EditSupplierProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the profile page to show the current details
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            SupplierDao supplierDao = new SupplierDao();
            Supplier supplier = supplierDao.getSupplierDetails(username); // Fetch current supplier details
            request.setAttribute("supplier", supplier);
            request.getRequestDispatcher("supplier_profile.jsp").forward(request, response);
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

        // Create a supplier object to hold the updated details
        Supplier supplier = new Supplier();
        supplier.setUsername(username);
        supplier.setName(fullName);
        supplier.setPhoneNumber(phoneNumber);
        supplier.setAddress(address);

        // Update the supplier's details in the database
        SupplierDao supplierDao = new SupplierDao();
        boolean isUpdated = supplierDao.updateSupplierDetails(supplier);

        if (isUpdated) {
            // Redirect back to the profile page with a success message
            request.setAttribute("successMessage", "Profile updated successfully.");
            request.setAttribute("supplier", supplier); // Set updated supplier details
            request.getRequestDispatcher("supplier_profile.jsp").forward(request, response);
        } else {
            // Handle the case where the update fails
            request.setAttribute("errorMessage", "Failed to update profile. Please try again.");
            request.getRequestDispatcher("supplier_profile.jsp").forward(request, response);
        }
    }
}