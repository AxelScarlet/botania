import bean.Supplier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LoginDao;

public class SupplierProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username"); // Assuming you store username in session
        LoginDao loginDao = new LoginDao();
        Supplier supplier = loginDao.getSupplierDetails(username);
        request.setAttribute("supplier", supplier);
        request.getRequestDispatcher("supplier_profile.jsp").forward(request, response);
    }
}
