import bean.Farmer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LoginDao;

public class FarmerProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username"); // Assuming you store username in session
        LoginDao loginDao = new LoginDao();
        Farmer farmer = loginDao.getFarmerDetails(username);
        request.setAttribute("farmer", farmer);
        request.getRequestDispatcher("farmer_profile.jsp").forward(request, response);
    }
}