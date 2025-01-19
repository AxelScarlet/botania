import bean.Complaint;
import dao.ComplaintDao; // Assuming you have a DAO class for handling complaints
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/FileComplaintServlet")
public class FileComplaintServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the complaint details from the request
        String complaintTitle = request.getParameter("complaintTitle");
        String complaintDescription = request.getParameter("complaintDescription");

        // Validate the input
        if (complaintTitle == null || complaintTitle.isEmpty() || complaintDescription == null || complaintDescription.isEmpty()) {
            request.setAttribute("error", "Complaint title and description cannot be empty.");
            request.getRequestDispatcher("file_farmerComplaint.jsp").forward(request, response);
            return;
        }

        // Get the session to retrieve the username or any other necessary information
        HttpSession session = request.getSession(false);
        String username = (session != null) ? (String) session.getAttribute("username") : null;

        // Create a Complaint object
        Complaint complaint = new Complaint();
        complaint.setTitle(complaintTitle);
        complaint.setDescription(complaintDescription);
        complaint.setUsername(username); // Set the username if needed

        // Use the DAO to save the complaint
        ComplaintDao complaintDao = new ComplaintDao();
        boolean isSaved = complaintDao.saveComplaint(complaint);

        // Provide feedback to the user
        if (isSaved) {
            request.setAttribute("message", "Complaint filed successfully!");
        } else {
            request.setAttribute("error", "Failed to file complaint. Please try again.");
        }

        // Redirect back to the appropriate page
        request.getRequestDispatcher("file_farmerComplaint.jsp").forward(request, response);
    }
}