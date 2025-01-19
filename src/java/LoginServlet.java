
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import bean.LoginBean;
import dao.LoginDao;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();
        String userRole = loginDao.authenticateUser (loginBean);

        System.out.println("Username: " + username); // Debugging line
        System.out.println("User  Role: " + userRole); // Debugging line

        if ("farmer".equals(userRole)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username); // Ensure this line is present
            RequestDispatcher farmerDispatcher = request.getRequestDispatcher("farmerHome.jsp");
            farmerDispatcher.forward(request, response);
        } else if ("admin".equals(userRole)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username); // Ensure this line is present
            RequestDispatcher adminDispatcher = request.getRequestDispatcher("adminHome.jsp");
            adminDispatcher.forward(request, response);
        }else if ("supplier".equals(userRole)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username); // Ensure this line is present
            RequestDispatcher supplierDispatcher = request.getRequestDispatcher("supplierHome.jsp");
            supplierDispatcher.forward(request, response);
        }
        else {
            // Handle other roles or invalid credentials
            request.setAttribute("errMessage", "Invalid user credentials");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}