import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import bean.registerBean;
import dao.RegisterDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String name = request.getParameter("full_name");
        String phoneNumber = request.getParameter("phone");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        if (role == null || role.isEmpty() ||
            username == null || username.isEmpty() ||
            name == null || name.isEmpty() ||
            phoneNumber == null || phoneNumber.isEmpty() ||
            address == null || address.isEmpty() ||
            password == null || password.isEmpty()) {
            request.setAttribute("errMessage", "All fields are required.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }

        registerBean registerBean = new registerBean(username, name, phoneNumber, address, password);
        RegisterDao registerDao = new RegisterDao();
        String userRegistered = registerDao.registerUser(registerBean, role);

        if (userRegistered.equals("SUCCESS")) {
            request.setAttribute("successMessage", "Registration successful!");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("errMessage", userRegistered);
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }
    }
}
